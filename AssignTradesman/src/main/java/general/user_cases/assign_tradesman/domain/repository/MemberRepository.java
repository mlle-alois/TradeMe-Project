package general.user_cases.assign_tradesman.domain.repository;

import general.kernel.Repository;
import general.user_cases.assign_tradesman.domain.Tradesman;
import general.user_cases.assign_tradesman.domain.valueObjects.MemberId;

import java.util.List;


public interface MemberRepository extends Repository<MemberId, Tradesman> {
    List<Tradesman> findAll();
}
