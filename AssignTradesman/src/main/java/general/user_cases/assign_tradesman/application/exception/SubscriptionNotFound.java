package general.user_cases.assign_tradesman.application.exception;

import  general.user_cases.assign_tradesman.domain.Log;
import  general.user_cases.assign_tradesman.domain.valueObjects.LogId;
import  general.user_cases.assign_tradesman.infrastructure.InMemoryLogRepository;

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
