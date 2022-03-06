package general.application.exception;


import general.domain.Log;
import general.domain.valueObjects.LogId;
import general.infrastructure.InMemoryLogRepository;

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
