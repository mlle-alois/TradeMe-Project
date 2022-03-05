package general.user_cases.apply_for_certificate.application.exception;

import general.user_cases.apply_for_certificate.domain.Log;
import general.user_cases.apply_for_certificate.domain.valueObjects.LogId;
import general.user_cases.apply_for_certificate.infrastructure.InMemoryLogRepository;

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
