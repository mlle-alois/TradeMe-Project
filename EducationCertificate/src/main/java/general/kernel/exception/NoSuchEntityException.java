package general.kernel.exception;

import general.kernel.ValueObjectID;
import general.user_cases.apply_for_certificate.domain.Log;
import general.user_cases.apply_for_certificate.domain.valueObjects.LogId;
import general.user_cases.apply_for_certificate.infrastructure.InMemoryLogRepository;

public final class NoSuchEntityException extends RuntimeException {
    private static final String messageStart = "No entity found with ID %d.";

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(ValueObjectID id) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(Log.of(logid, messageStart + id));
        return new NoSuchEntityException(String.format(messageStart, id.getValue()));
    }
}
