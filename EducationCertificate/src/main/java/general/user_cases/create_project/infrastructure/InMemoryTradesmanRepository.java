package general.user_cases.create_project.infrastructure;

import general.kernel.exception.NoSuchEntityException;
import general.user_cases.create_project.domain.Member;
import general.user_cases.create_project.domain.Tradesman;
import general.user_cases.create_project.domain.repository.TradesmanRepository;
import general.user_cases.create_project.domain.valueObjects.TradesmanId;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryTradesmanRepository implements TradesmanRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<TradesmanId, Tradesman> data = new ConcurrentHashMap<>();

    @Override
    public TradesmanId nextIdentity() {
        return new TradesmanId(count.incrementAndGet());
    }

    @Override
    public Tradesman findById(TradesmanId id) throws NoSuchEntityException {
        final Tradesman tradesman = data.get(id);
        if (tradesman == null) {
            throw NoSuchEntityException.withId(id);
        }
        return tradesman;
    }

    @Override
    public void add(Tradesman entity) {
        data.put(entity.getTradesmanId(),entity);
    }

    @Override
    public void delete(TradesmanId id) {
        data.remove(id);
    }

    @Override
    public List<Tradesman> findAll() {
        return null;
    }
}
