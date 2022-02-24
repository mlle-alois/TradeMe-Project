package general.user_cases.create_project.application;

import general.kernel.ApplicationEvent;
import general.user_cases.create_project.domain.valueObjects.MemberId;

public final class ApplyForMembershipEvent implements ApplicationEvent {
    private final MemberId memberId;

    public ApplyForMembershipEvent(MemberId memberId) {
        this.memberId = memberId;
    }
}
