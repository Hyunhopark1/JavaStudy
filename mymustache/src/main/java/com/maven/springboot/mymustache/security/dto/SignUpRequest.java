package com.maven.springboot.mymustache.security.dto;

import com.maven.springboot.mymustache.commons.dto.BaseNullRequest;
import com.maven.springboot.mymustache.member.IMember;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest extends LoginRequest implements IMember {
    private Long id;
    @Size(min = 3, max = 20, message = "이름은 3~20자 이어야 합니다.")
    private String name;
    @Size(min = 5, max = 20, message = "닉네임은 5~20자 이어야 합니다.")
    private String nickname;
    @Size(min = 1, max = 150, message = "이메일은 1~150자 이어야 합니다.")
    private String email;
    private String role;
    private Boolean active;
}
