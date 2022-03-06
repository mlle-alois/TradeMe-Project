package general.user_cases.assign_tradesman.infrastructure;

import general.kernel.exception.NoSuchEntityException;
import general.user_cases.assign_tradesman.domain.Tradesman;
import general.user_cases.assign_tradesman.domain.repository.MemberRepository;
import general.user_cases.assign_tradesman.domain.valueObjects.MemberId;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryMemberRepository implements MemberRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<MemberId, Tradesman> data = new ConcurrentHashMap<>();

    @Override
    public List<Tradesman> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public MemberId nextIdentity() {
        return MemberId.of(count.incrementAndGet());
    }

    @Override
    public Tradesman findById(MemberId id) throws NoSuchEntityException {
        final Tradesman member = data.get(id);
        if (member == null) {
            throw NoSuchEntityException.withId(id);
        }
        return member;
    }

    @Override
    public void add(Tradesman member) {
        data.put(member.id(), member);
    }

    @Override
    public void delete(MemberId id) {
        data.remove(id);
    }
}
