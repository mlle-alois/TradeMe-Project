package general.user_cases.create_project.infrastructure;

import general.kernel.exception.NoSuchEntityException;
import general.user_cases.create_project.domain.Member;
import general.user_cases.create_project.domain.valueObjects.MemberId;
import general.user_cases.create_project.domain.repository.MemberRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryMemberRepository implements MemberRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<MemberId, Member> data = new ConcurrentHashMap<>();

    @Override
    public List<Member> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public MemberId nextIdentity() {
        return MemberId.of(count.incrementAndGet());
    }

    @Override
    public Member findById(MemberId id) throws NoSuchEntityException {
        final Member member = data.get(id);
        if (member == null) {
            throw NoSuchEntityException.withId(id);
        }
        return member;
    }

    @Override
    public void add(Member member) {
        data.put(member.id(), member);
    }

    @Override
    public void delete(MemberId id) {
        data.remove(id);
    }
}
