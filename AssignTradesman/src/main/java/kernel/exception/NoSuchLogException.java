package kernel.exception;

import  domain.Log;
import  domain.valueObjects.LogId;
import  infrastructure.InMemoryLogRepository;

public final class NoSuchLogException extends RuntimeException {
    private static final String messageStart = "No log entity found with ID %d.";

    public NoSuchLogException(String message) {
        super(message);
    }

    public static NoSuchLogException withId(LogId id) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(Log.of(logid, messageStart + id));
        return new NoSuchLogException(String.format(messageStart, id.getValue()));
    }
}
