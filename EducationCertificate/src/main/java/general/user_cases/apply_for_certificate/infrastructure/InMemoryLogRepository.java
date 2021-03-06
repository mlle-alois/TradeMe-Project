package general.user_cases.apply_for_certificate.infrastructure;

import general.kernel.exception.NoSuchEntityException;
import general.kernel.exception.NoSuchLogException;
import general.user_cases.apply_for_certificate.domain.Log;
import general.user_cases.apply_for_certificate.domain.repository.LogRepository;
import general.user_cases.apply_for_certificate.domain.valueObjects.LogId;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryLogRepository implements LogRepository {

    private static final InMemoryLogRepository single_instance = new InMemoryLogRepository();
    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<LogId, Log> data = new ConcurrentHashMap<>();

    @Override
    public LogId nextIdentity() {
        return LogId.of(count.incrementAndGet());
    }

    @Override
    public Log findById(LogId id) throws NoSuchEntityException {
        final Log log = data.get(id);
        if (log == null) {
            throw NoSuchLogException.withId(id);
        }
        return log;
    }

    @Override
    public void add(Log entity) {
        data.put(entity.id(), entity);
    }

    @Override
    public void delete(LogId id) {
        data.remove(id);
    }

    public static InMemoryLogRepository getInstance() {
        return single_instance;
    }

    @Override
    public List<Log> findAll() {
        return List.copyOf(data.values());
    }
}
