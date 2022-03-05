package general.user_cases.apply_for_certificate.application.exception;

import general.user_cases.apply_for_certificate.domain.Log;
import general.user_cases.apply_for_certificate.domain.valueObjects.LogId;
import general.user_cases.apply_for_certificate.infrastructure.InMemoryLogRepository;

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
