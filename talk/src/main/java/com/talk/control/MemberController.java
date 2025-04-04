package com.talk.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talk.Dto.MemberSignInDto;
import com.talk.Dto.MemberSignUpDto;
import com.talk.Repository.MemberRepository;
import com.talk.Service.BoardService;
import com.talk.Service.MemberService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RequestMapping("/member") //member 시작하는 주소 매핑
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	// 회원가입 요청
	@PostMapping("/signUp")
	public String signUp(@Valid MemberSignUpDto memberSignUpDto, 
			BindingResult bindingResult  ,Model model) {
		if(bindingResult.hasErrors()) {
			//valid가 유효값 체크하여 유효하지 않은 경우 에러가 발생한다.
			//최근글 5개 가져오기
			model.addAttribute("recentList", boardService.boardRecent() );
			//인기글 5개 가져오기
			model.addAttribute("popularList", boardService.boardPupular()); 
			
			//첫 페이지에서 로그인하기
			model.addAttribute("memberSignInDto", new MemberSignInDto());
			model.addAttribute("open",1);
			return "index";
			
		}
		//회원가입을 하기 위해 입력한 값들이 올바른 값이라면 여기서부터 동작/위 if문은 올바르지 않을 경우 실행
		memberService.memberSave(memberSignUpDto);
		
		return "redirect:/";
	}
	// 로그인 요청
	@PostMapping("/signIn")
	public String signIn(@Valid MemberSignInDto memberSignInDto,
			BindingResult bindingResult, HttpSession session , Model model) {
		
		boolean hasError=bindingResult.hasErrors();
		if(!hasError) {
			hasError = memberService.memberLogin(memberSignInDto);
			if(hasError)
				bindingResult.reject("fail","아이디 또는 비밀번호를 잘못입력했습니다");
		}
		
		if(hasError) { //로그인 아이디 또는 비밀번호 입력안하거나 길이 맞지 않거나 영어 숫자 아닌경우
			//최근글 5개 가져오기
			model.addAttribute("recentList", boardService.boardRecent() );
			//인기글 5개 가져오기
			model.addAttribute("popularList", boardService.boardPupular()); 
			
			model.addAttribute("memberSignUpDto", new MemberSignUpDto());
			model.addAttribute("show",1);
			return "index";
		}
		
		// 여기서부터 실행되는 코드는 아이디 비밀번호가 잘 입력되어서 로그인 성공이다.
		session.setAttribute("user", memberSignInDto.getMemberId());
		
		return "redirect:/";
	}
}
