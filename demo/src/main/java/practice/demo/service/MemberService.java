package practice.demo.service;

import practice.demo.domain.Member;
import practice.demo.dto.MemberSignUpDto;
import practice.demo.repository.MemberRepository;

import java.util.List;

public interface MemberService {
    List<Member> findMembers();

    Member addMember(MemberSignUpDto memberSignUpDto);

    Member findById(long memberId);

    Member update(long id, Member member);
}
