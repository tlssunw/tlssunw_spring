package com.talk.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignUpDto {
	@NotEmpty(message="아이디는 필수입니다.")
	@Size(min = 5, max=12, message="5자 이상 12자 이하로 입력하세요")
	@Pattern(regexp="^[a-z0-9]*$", message="영어소문자와 숫자만 입력하세요")
	private String memberId;
	
	@NotEmpty(message="비밀번호는 필수입니다.")
	@Size(min = 6, max=16, message="6자 이상 16자 이하로 입력하세요")
	@Pattern(regexp="^[a-zA-Z0-9]*$", message="영어대소문자와 숫자만 입력하세요")
	private String password;
	
	@NotBlank(message=" 이름은 필수입니다 ")
	private String name;
	
	@NotEmpty(message="이메일은 필수입니다")
	private String email;
	private String tel;
	
	
}
