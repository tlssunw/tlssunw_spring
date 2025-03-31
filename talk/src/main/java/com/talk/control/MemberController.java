package com.talk.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.talk.Repository.MemberRepository;
import com.talk.Service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
}
