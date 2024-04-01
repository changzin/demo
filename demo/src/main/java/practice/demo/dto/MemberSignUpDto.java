package practice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberSignUpDto {
    private String name;
    private String password;
}
