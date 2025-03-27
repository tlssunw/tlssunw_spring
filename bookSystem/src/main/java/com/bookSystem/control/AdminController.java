package com.bookSystem.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookSystem.DTO.BookWriteDto;
import com.bookSystem.Service.BookService;

@Controller
@RequestMapping("/admin") //localhost/admin/*** 으로 되어 있는 모든 주소 매핑
public class AdminController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/bookEnroll") //localhost/admin/bookEnroll 주소 매핑
	public String enrollPage(Model model) {
		
		model.addAttribute("bookWriteDto", new BookWriteDto() );
		return "book/bookWrite";
		
	}
	
	@GetMapping("/bookSave")
	public String saveBook(BookWriteDto bookWriteDto) {
		bookService.bookSave(bookWriteDto);
		
		return "redirect:/";
	}
}
