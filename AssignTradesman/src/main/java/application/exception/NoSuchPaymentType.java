package application.exception;

import  domain.Log;
import  domain.valueObjects.LogId;
import  infrastructure.InMemoryLogRepository;

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
