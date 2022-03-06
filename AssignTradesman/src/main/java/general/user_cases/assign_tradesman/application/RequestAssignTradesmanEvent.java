package general.user_cases.assign_tradesman.application;

import general.kernel.ApplicationEvent;
import general.user_cases.assign_tradesman.domain.valueObjects.MemberId;

import java.util.Objects;

public final class RequestAssignTradesmanEvent implements ApplicationEvent {
    private final MemberId memberId;

    public RequestAssignTradesmanEvent(MemberId memberId) {
        this.memberId = Objects.requireNonNull(memberId);
    }
}
