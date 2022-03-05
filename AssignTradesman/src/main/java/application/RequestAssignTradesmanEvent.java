package application;

import kernel.ApplicationEvent;
import domain.valueObjects.ProjectId;

import java.util.Objects;

public final class RequestAssignTradesmanEvent implements ApplicationEvent {
    private final ProjectId projectId;

    public RequestAssignTradesmanEvent(ProjectId projectId) {
        this.projectId = Objects.requireNonNull(projectId);
    }
}
