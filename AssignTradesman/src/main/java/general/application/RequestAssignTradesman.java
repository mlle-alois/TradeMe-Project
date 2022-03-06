package general.application;


import general.domain.valueObjects.MemberId;
import general.domain.valueObjects.ProjectId;
import kernel.Command;

import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class RequestAssignTradesman implements Command {
    public final ProjectId projectId;
    public final MemberId memberId;


    public RequestAssignTradesman(ProjectId projectId, MemberId memberId) {
        this.projectId = Objects.requireNonNull(projectId);
        this.memberId = Objects.requireNonNull(memberId);

    }
}
