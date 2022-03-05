package exposition;

import domain.valueObjects.MemberId;
import domain.valueObjects.ProjectId;
import  kernel.CommandBus;
import application.RequestAssignTradesman;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public final class ProjectController {

    private final CommandBus commandBus;
    private static final String projects = "/projects";

    public ProjectController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }


    @PostMapping(path = projects, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid ProjectRequest request) {

        RequestAssignTradesman createProject = new RequestAssignTradesman(request.projectName, MemberId.of(request.contractorId), request.startDate, request.endDate,
                 request.durationOfEngagementInDays);
        ProjectId projectId = commandBus.send(createProject);
        return ResponseEntity.created(URI.create(projects + projectId.getValue())).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
