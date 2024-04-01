package practice.demo.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import practice.demo.domain.Member;
import practice.demo.dto.MemberSignUpDto;
import practice.demo.service.MemberService;
import practice.demo.service.MemberServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String members(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/{memberId}")
    public String findMember(@PathVariable long memberId, Model model){
        Member findMember = memberService.findById(memberId);
        model.addAttribute("member", findMember);
        return "member";
    }

    @GetMapping("/new")
    public String addMemberForm(){
        return "newmember";
    }

    @PostMapping("/new")
    public String addMember(MemberSignUpDto memberSignUpDto, RedirectAttributes redirectAttributes){
        Member addMember = memberService.addMember(memberSignUpDto);
        redirectAttributes.addAttribute("memberId", addMember.getId());
        return "redirect:/members/{memberId}";
    }

    @GetMapping("/edit/{memberId}")
    public String editMemberForm(@PathVariable long memberId, Model model){
        Member member = memberService.findById(memberId);
        model.addAttribute("member", member);
        return "editmember";
    }

    @PostMapping("/edit/{memberId}")
    public String updateMember(Member member, Model model, RedirectAttributes redirectAttributes){
        Member updateMember = memberService.update(member.getId(), member);
        model.addAttribute("member", updateMember);
        redirectAttributes.addAttribute("memberId", updateMember.getId());
        return "redirect:/members/{memberId}";
    }

    @PostConstruct
    public void init(){
        memberService.addMember(new MemberSignUpDto("Kim", "qwer1234"));
        memberService.addMember(new MemberSignUpDto("Park", "Park1234"));
    }
}
