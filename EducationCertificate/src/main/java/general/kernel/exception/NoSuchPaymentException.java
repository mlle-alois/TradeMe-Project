package general.kernel.exception;

import general.user_cases.apply_for_certificate.domain.Log;
import general.user_cases.apply_for_certificate.domain.valueObjects.LogId;
import general.user_cases.apply_for_certificate.domain.valueObjects.PaymentId;
import general.user_cases.apply_for_certificate.infrastructure.InMemoryLogRepository;

public final class NoSuchPaymentException extends RuntimeException {
    private static final String messageStart = "No Payment entity found with ID %d.";

    public NoSuchPaymentException(String message) {
        super(message);
    }


    public static NoSuchPaymentException withId(PaymentId id) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(Log.of(logid, messageStart + id));
        return new NoSuchPaymentException(String.format(messageStart, id.getValue()));
    }

}


