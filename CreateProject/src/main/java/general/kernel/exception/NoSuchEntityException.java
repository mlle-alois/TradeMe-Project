package general.kernel.exception;

import general.kernel.ValueObjectID;
import general.user_cases.create_project.domain.Log;
import general.user_cases.create_project.domain.valueObjects.LogId;
import general.user_cases.create_project.domain.valueObjects.MemberId;
import general.user_cases.create_project.domain.valueObjects.ProjectId;
import general.user_cases.create_project.infrastructure.InMemoryLogRepository;

public final class NoSuchEntityException extends RuntimeException {
    private static final String messageStart = "No entity found with ID %d.";

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(ValueObjectID id) {
        InMemoryLogRepository inMemoryLogRepository = InMemoryLogRepository.getInstance();
        LogId logid = inMemoryLogRepository.nextIdentity();
        inMemoryLogRepository.add(Log.of(logid, messageStart + id));
        return new NoSuchEntityException(String.format(messageStart, id.getValue()));
    }
}
