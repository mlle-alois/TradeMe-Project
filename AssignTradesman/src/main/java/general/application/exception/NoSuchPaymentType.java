package general.application.exception;


import general.domain.Log;
import general.domain.valueObjects.LogId;
import general.infrastructure.InMemoryLogRepository;

public final class NoSuchPaymentType extends RuntimeException {
    private static final String messageStart = "No Payment type for ";

    public NoSuchPaymentType(String message) {
        super(message);
    }

    public static NoSuchPaymentType WithLog(String input) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(Log.of(logid, messageStart + input));
        return new NoSuchPaymentType(messageStart + input);
    }
}
