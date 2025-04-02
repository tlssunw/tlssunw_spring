package com.talk.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talk.Dto.MemberSignInDto;
import com.talk.Repository.MemberRepository;
import com.talk.Service.MemberService;

@RequestMapping("/member") //member 시작하는 주소 매핑
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	// 회원가입 요청
	@PostMapping("/signUp")
	public String signUp(MemberController memberSignUpDto, Model model) {
		return null;
	}
	// 로그인 요청
	@PostMapping("/signIp")
	public String signIn(MemberSignInDto memberSignInDto, Model model) {
		return null;
	}
}
