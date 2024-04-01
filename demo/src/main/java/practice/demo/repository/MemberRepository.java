package practice.demo.repository;

import practice.demo.domain.Member;
import practice.demo.dto.MemberSignUpDto;

import java.util.List;

public interface MemberRepository {
    List<Member> findMembers();

    Member addMember(MemberSignUpDto memberSignUpDto);

    Member findById(long memberId);

    Member updateMember(long id, Member member);
}
