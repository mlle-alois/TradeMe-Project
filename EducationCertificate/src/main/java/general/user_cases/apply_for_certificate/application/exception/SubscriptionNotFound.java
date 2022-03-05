package general.user_cases.apply_for_certificate.application.exception;

import general.user_cases.apply_for_certificate.domain.Log;
import general.user_cases.apply_for_certificate.domain.valueObjects.LogId;
import general.user_cases.apply_for_certificate.infrastructure.InMemoryLogRepository;

public final class SubscriptionNotFound extends RuntimeException {
    private static final String messageStart = "Subscription not found for ";

    public SubscriptionNotFound(String message) {
        super(message);
    }

    public static SubscriptionNotFound WithLog(String input) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(Log.of(logid, messageStart + input));
        return new SubscriptionNotFound(messageStart + input);
    }


}
