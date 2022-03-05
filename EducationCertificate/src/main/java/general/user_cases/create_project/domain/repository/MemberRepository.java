package general.user_cases.create_project.domain.repository;

import general.kernel.Repository;
import general.user_cases.create_project.domain.Member;
import general.user_cases.create_project.domain.valueObjects.MemberId;

import java.util.List;


public interface MemberRepository extends Repository<MemberId, Member> {
    List<Member> findAll();
}
