package general.kernel;

import general.user_cases.member.domain.Log;
import general.user_cases.member.domain.LogId;
import general.user_cases.member.domain.MemberId;
import general.user_cases.member.infrastructure.InMemoryLogRepository;

public final class NoSuchEntityException extends RuntimeException {
    private static final String messageStart = "No entity found with ID %d." ;

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(MemberId id) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(new Log(logid,messageStart + id));
        return new NoSuchEntityException(String.format(messageStart, id.getValue()));
    }
}
