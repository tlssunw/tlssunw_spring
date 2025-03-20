package com.springStudy1.conrtol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainControl {
	
	@GetMapping("/test")
	// test라는 주소에 대한 처리 (localhost/test라는 주소인 경우 처리)
	public String testPage() {
		//localhost/test라는 주소를 열면 해당 메소드 처리됨
		System.out.println("와 진짜 실행된다 한글쪼아");
		return "hello.html";
	}
	
//	@PostMapping("/save")
//	public String boardSave() {
//		// localhost/save 주소가 post방식으로 요청되는 경우
//		// boardsave메서드 실행
//	}

}
