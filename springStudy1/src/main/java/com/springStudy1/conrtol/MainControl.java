package com.springStudy1.conrtol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springStudy1.DTO.School;
import com.springStudy1.DTO.User;
import com.springStudy1.service.SchoolService;
import com.springStudy1.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainControl {
	
	@Autowired
	private SchoolService schoolservice;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/test")
	// test라는 주소에 대한 처리 (localhost/test라는 주소인 경우 처리)
	public String testPage() {
		//localhost/test라는 주소를 열면 해당 메소드 처리됨
		System.out.println("와 진짜 실행된다 한글쪼아");
		return "hello.html";
	}
	
	// 로그인화면
	@GetMapping("/signIn")
	public String login() {
		return "signIn";
	}
	@PostMapping("/signIn")
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw
			, HttpSession session) {
		// 매개변수를 통해 session 객체 가져오기
		boolean isSuccess = userService.loginChk(id, pw);
		if(isSuccess)
			session.setAttribute("user", id);
		
		return "index";
	}
	
	//회원가입 화면
	@GetMapping("/signUp")
	public String join() {
		return "signUp";
	}
	@PostMapping("/signUp")
	public String joinSave(@ModelAttribute User user) {
		
		System.out.println(user.getUserId());
		userService.save(user);
	
		
		return "index"; //회원가입 저장하고 첫페이지 돌려보내기
	}
	
	//정보수정 화면
	@GetMapping("/userUpdate")
	public String memberUpdate() {
		return "memberModify";
	}
	
	@GetMapping("/")
	public String homepage() {
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView litPage(@RequestParam String type) {
		System.out.println(type);
		ModelAndView mav = new ModelAndView("list");
//		mav.setViewName("");
	
		// 클아이언트가 요청한 유치원, 초등학교, 중학교, 고등학교에 대해 조회하기 위해 
		// service클래스 객체에 넘겨주고 필요한 데이터를 받아서 뷰페이지와 함께 클라이언트에게 전달
		
		List<School> list = schoolservice.typeSelect(type);
		mav.addObject("list",list); //ModelAndView에 저장
	
		return mav;
	}
	
	
	// 주소:http://localhost/signIn
	// 뷰 페이지: signIn.html
	//     내용: 아이디, 비밀번호 입력 가능하게
	
//	@PostMapping("/save")
//	public String boardSave() {
//		// localhost/save 주소가 post방식으로 요청되는 경우
//		// boardsave메서드 실행
//	}

}
