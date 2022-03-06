package general.domain.repository;


import general.domain.Tradesman;
import general.domain.valueObjects.MemberId;
import kernel.Repository;

import java.util.List;

public interface MemberRepository extends Repository<MemberId, Tradesman> {
    List<Tradesman> findAll();
}
