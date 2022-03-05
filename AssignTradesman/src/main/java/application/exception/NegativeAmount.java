package application.exception;

import  domain.Log;
import  domain.valueObjects.LogId;
import  infrastructure.InMemoryLogRepository;

public final class NegativeAmount extends RuntimeException {
    private static final String messageStart = "Negative amount for ";

    public NegativeAmount(String message) {
        super(message);
    }

    public static NegativeAmount WithLog(Double input) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(Log.of(logid, messageStart + input));
        return new NegativeAmount(messageStart + input);
    }
}
