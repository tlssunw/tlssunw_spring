package com.bookSystem.Repository;

import org.apache.ibatis.annotations.Mapper;

import com.bookSystem.DTO.MemberDTO;

@Mapper
public interface MemberRepository {	

	public String login(MemberDTO memberDto);
	
	//로그인한 회원의 이메일을 통해 id 구하기
	public int findByEmail(String email);

}
