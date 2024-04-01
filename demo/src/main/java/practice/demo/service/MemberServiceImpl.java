package practice.demo.service;

import org.springframework.stereotype.Service;
import practice.demo.domain.Member;
import practice.demo.dto.MemberSignUpDto;
import practice.demo.repository.MemberRepository;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findMembers();
    }

    @Override
    public Member addMember(MemberSignUpDto memberSignUpDto) {
        Member addMember = memberRepository.addMember(memberSignUpDto);
        return addMember;
    }

    @Override
    public Member findById(long memberId) {
        Member findMember = memberRepository.findById(memberId);
        return findMember;
    }

    @Override
    public Member update(long id, Member member) {
        Member updateMember = memberRepository.updateMember(id, member);
        return updateMember;
    }
}
