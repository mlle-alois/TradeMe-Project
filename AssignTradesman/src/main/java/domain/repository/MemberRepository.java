package domain.repository;

import kernel.Repository;
import domain.Member;
import domain.valueObjects.MemberId;

import java.util.List;


public interface MemberRepository extends Repository<MemberId, Member> {
    List<Member> findAll();
}
