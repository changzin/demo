package practice.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import practice.demo.dto.MemberSignUpDto;

@Data
@NoArgsConstructor
public class Member {
    private long id;
    private String name;
    private String password;

    public Member(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Member(MemberSignUpDto memberSignUpDto){
        this.name = memberSignUpDto.getName();
        this.password = memberSignUpDto.getPassword();
    }
}
