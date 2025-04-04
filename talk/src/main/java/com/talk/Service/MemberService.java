package com.talk.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talk.Dto.MemberSignInDto;
import com.talk.Dto.MemberSignUpDto;
import com.talk.Entity.MemberEntity;
import com.talk.Repository.MemberRepository;


@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	//회원가입
	public void memberSave(MemberSignUpDto memberSingUpDto) {
		MemberEntity memberEntity = MemberEntity.from(memberSingUpDto);
		memberRepository.insert(memberEntity);
	}
	//로그인 
	public boolean memberLogin(MemberSignInDto memberSignInDto) {
		MemberEntity memberEntity = MemberSignInDto.to(memberSignInDto);
		return !memberRepository.findByMemberIdAndPassword(memberEntity);
		
//		return false; //아이디 비밀번호 잘 입력했다!
	}
}
