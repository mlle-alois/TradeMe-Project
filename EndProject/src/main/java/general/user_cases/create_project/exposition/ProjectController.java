package general.user_cases.create_project.exposition;

import general.kernel.CommandBus;
import general.user_cases.create_project.application.CreateProject;
import general.user_cases.create_project.domain.Task;
import general.user_cases.create_project.domain.valueObjects.DailyRate;
import general.user_cases.create_project.domain.valueObjects.MemberId;
import general.user_cases.create_project.domain.valueObjects.ProjectId;
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
        List<Task> tasks = new ArrayList<>();
        for (TaskRequest taskRequest : request.tasks) {
            tasks.add(Task.of(taskRequest.taskName, taskRequest.aptitudeCertificates, taskRequest.specialities, taskRequest.skills, taskRequest.durationInDays));
        }
        CreateProject createProject = new CreateProject(request.projectName, MemberId.of(request.contractorId), tasks, request.startDate, request.endDate,
                request.location, DailyRate.of(request.desiredDailyRate), request.durationOfEngagementInDays);
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
