package practice.demo.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import practice.demo.domain.Member;
import practice.demo.dto.MemberSignUpDto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class MemoryMemberRepositoryImpl implements MemberRepository{

    private static long sequence = 0L;
    private static final ConcurrentHashMap<Long, Member> memberMap = new ConcurrentHashMap<>();

    @Override
    public List<Member> findMembers() {
        List<Member> members = new ArrayList<>(memberMap.values());
        return members;
    }

    @Override
    public Member addMember(MemberSignUpDto memberSignUpDto) {
        Member member = new Member(memberSignUpDto);
        member.setId(sequence++);
        long memberId = member.getId();
        memberMap.put(memberId, member);
        return memberMap.get(memberId);
    }

    @Override
    public Member findById(long memberId) {
        Member findMember = memberMap.get(memberId);
        return findMember;
    }

    @Override
    public Member updateMember(long id, Member member) {
        Member findMember = memberMap.get(id);

        findMember.setName(member.getName());
        findMember.setPassword(member.getPassword());
        return findMember;
    }
}
