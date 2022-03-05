package application.exception;

import  domain.Log;
import  domain.valueObjects.LogId;
import  infrastructure.InMemoryLogRepository;

public final class NoCurrencyForAmount extends RuntimeException {
    private static final String messageStart = "Negative amount for ";

    public NoCurrencyForAmount(String message) {
        super(message);
    }

    public static NoCurrencyForAmount WithLog(Double input) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(Log.of(logid, messageStart + input));
        return new NoCurrencyForAmount(messageStart + input);
    }

}
