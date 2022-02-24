package general.user_cases.create_project.domain.repository;

import general.kernel.Repository;
import general.user_cases.create_project.domain.valueObjects.MemberId;
import general.user_cases.create_project.domain.Member;

import java.util.List;


public interface MemberRepository extends Repository<MemberId, Member> {
    // void save(Member member);

    //Member byId(MemberId userId);

    //MemberId nextId();

    //List<Member> findAll();
    List<Member> findAll();
}
