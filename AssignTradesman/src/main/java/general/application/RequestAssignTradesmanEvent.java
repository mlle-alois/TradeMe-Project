package general.application;


import general.domain.valueObjects.MemberId;
import kernel.ApplicationEvent;

import java.util.Objects;

public final class RequestAssignTradesmanEvent implements ApplicationEvent {
    private final MemberId memberId;

    public RequestAssignTradesmanEvent(MemberId memberId) {
        this.memberId = Objects.requireNonNull(memberId);
    }
}
