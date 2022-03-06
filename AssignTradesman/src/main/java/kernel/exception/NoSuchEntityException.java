package kernel.exception;

import general.domain.Log;
import general.domain.valueObjects.LogId;
import general.infrastructure.InMemoryLogRepository;
import kernel.ValueObjectID;

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
