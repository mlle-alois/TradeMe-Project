package general.user_cases.create_project.application;

import general.kernel.ApplicationEvent;
import general.user_cases.create_project.domain.valueObjects.ProjectId;

import java.util.Objects;

public final class CreateProjectEvent implements ApplicationEvent {
    private final ProjectId projectId;

    public CreateProjectEvent(ProjectId projectId) {
        this.projectId = Objects.requireNonNull(projectId);
    }
}
