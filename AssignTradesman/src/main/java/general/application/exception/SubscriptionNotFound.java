package general.application.exception;

import general.domain.Log;
import general.domain.valueObjects.LogId;
import general.infrastructure.InMemoryLogRepository;

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
