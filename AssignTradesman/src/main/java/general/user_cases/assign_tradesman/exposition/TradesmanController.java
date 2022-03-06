package general.user_cases.assign_tradesman.exposition;

import general.user_cases.assign_tradesman.domain.valueObjects.MemberId;
import general.user_cases.assign_tradesman.domain.valueObjects.ProjectId;
import  general.kernel.CommandBus;
import general.user_cases.assign_tradesman.application.RequestAssignTradesman;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public final class TradesmanController {

    private final CommandBus commandBus;

    private static final String projects = "/tradesman";

    public TradesmanController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }


    @PostMapping(path = projects, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> assign(@RequestBody @Valid TradesmanRequest request) {

        RequestAssignTradesman assignTradesman = new RequestAssignTradesman(ProjectId.of(request.projectId), MemberId.of(request.tradesmanId));
        ProjectId projectId = commandBus.send(assignTradesman);
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
