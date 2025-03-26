package com.bookSystem.Repository;

import org.apache.ibatis.annotations.Mapper;

import com.bookSystem.DTO.MemberDTO;

@Mapper
public interface MemberRepository {	

	public String login(MemberDTO memberDto);

}
