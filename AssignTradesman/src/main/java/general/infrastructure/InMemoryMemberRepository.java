package general.infrastructure;


import general.domain.Tradesman;
import general.domain.repository.MemberRepository;
import general.domain.valueObjects.MemberId;
import kernel.exception.NoSuchEntityException;

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
