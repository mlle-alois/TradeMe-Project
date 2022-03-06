package general.user_cases.assign_tradesman.application;

import general.kernel.Command;
import general.user_cases.assign_tradesman.domain.valueObjects.MemberId;
import general.user_cases.assign_tradesman.domain.valueObjects.ProjectId;

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
