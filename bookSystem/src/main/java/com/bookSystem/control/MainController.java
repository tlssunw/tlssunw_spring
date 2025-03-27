package com.bookSystem.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookSystem.DTO.BookListDto;
import com.bookSystem.DTO.BookSearchDto;
import com.bookSystem.DTO.MemberDTO;
import com.bookSystem.Service.BookService;
import com.bookSystem.Service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String home(Model model) {
		MemberDTO memberDTO = new MemberDTO();
		model.addAttribute("memberDTO",memberDTO);
		return "index";
	}
	
	@PostMapping("/signIn")
	public String login( MemberDTO memberDTO, HttpSession session, Model model ) {
		System.out.println( memberDTO.getEmail() );
		
		// 로그인처리를 진행하려면 service 의 메서드를 호출한다. 
		// member와 관련 된것은 MemberService에서 처리한다. 
		// 컨트롤 쪽에서는  로그인처리과정이 어떻게 진행되고 하는지 전혀 몰라도 된다.
		// 그냥 service쪽 메서드를 호출하면 된다.
		boolean isSuccess = memberService.signIn( memberDTO );
		
		if(isSuccess) { // 로그인 성공 시 동작
			session.setAttribute("user", memberDTO.getEmail());
			return "redirect:/";
		}
		// 로그인 실패시 index.html 다시 돌아가기  
		model.addAttribute("fail", 1);
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	// 도서 검색 부분
	@GetMapping("/bookSearch")
	public String search(Model model) {
		
		model.addAttribute("bookSearchDto",new BookSearchDto() );
		
		return "book/search";
	}
	@GetMapping("/bookSearch/result")
	public String searchResult(BookSearchDto bookSearchDto, Model model ) {
		
		List<BookListDto> bookListDtos =  bookService.bookSearch(bookSearchDto);
		model.addAttribute("bookListDtos", bookListDtos);
		
		return "book/search";
	}
	
	
	
	// 도서 검색 부분 끝
	
	
	
	
//	@GetMapping("/test")
//	public String main(Model model) {
//		model.addAttribute("name", "곽찬양");
//		model.addAttribute("age", 30);
//		model.addAttribute("tel","010-1234-4567");
//		model.addAttribute("address","남아프리카 공화국");
//		
//		MemberDTO memberDto = new MemberDTO();
//		memberDto.setAge(29);
//		memberDto.setId("rim");
//		memberDto.setName("김은우");
//		memberDto.setTel("010-8888-0000");
//		
//		model.addAttribute("user", memberDto);
//		
//		List<String> animal=new ArrayList<>();
//		animal.add("개"); animal.add("호랑이");
//		animal.add("뱀"); animal.add("닭");
//		animal.add("토끼"); animal.add("소");
//		
//		model.addAttribute("animal",animal);
//		
//		return "test";
//	}
//	
//	@GetMapping("/test2")
//	public String test() {
//		return "test2";
//	}

}


/*
스프링의 동작은 기본적으로 mvc패턴이다
m : 모델 (데이터 다루기 위한 클래스)
v :  뷰 (화면 페이지 - html )
c : 컨트롤
요청 -> 컨트롤 -> 로직(서비스) -> DAO(레포지토리) -> 서비스 -> 컨트롤 -> client
 */
