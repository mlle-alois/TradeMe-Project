package general.user_cases.create_project.application.exception;

import general.user_cases.create_project.domain.Log;
import general.user_cases.create_project.domain.valueObjects.LogId;
import general.user_cases.create_project.infrastructure.InMemoryLogRepository;

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
