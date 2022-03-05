package general.user_cases.apply_for_certificate.domain.repository;

import general.kernel.Repository;
import general.user_cases.apply_for_certificate.domain.Member;
import general.user_cases.apply_for_certificate.domain.valueObjects.MemberId;

import java.util.List;


public interface MemberRepository extends Repository<MemberId, Member> {
    List<Member> findAll();
}
