package com.talk.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.talk.Dto.MemberSignInDto;
import com.talk.Dto.MemberSignUpDto;
import com.talk.Service.BoardService;

@Controller
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String home(Model model) {
		//최근글 5개 가져오기
		model.addAttribute("recentList", boardService.boardRecent() );
		//인기글 5개 가져오기
		model.addAttribute("popularList", boardService.boardPupular()); 
		
		//첫 페이지에서 로그인하기
		model.addAttribute("memberSignInDto", new MemberSignInDto());
		//회원가입도 가능하게 하기
		model.addAttribute("memberSignUpDto", new MemberSignUpDto());
		
		return "index";
	}
	

}
