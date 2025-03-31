package com.talk.Entity;

import java.time.LocalDate;

import com.talk.Dto.CommentDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentEntity {
	private int id;
	private int boardId;
	private String memberId;
	private String content;
	private LocalDate writerDate;
	
	public static CommentEntity of(CommentDto commentDto) {
		CommentEntity commentEntity = new CommentEntity();
		
		return commentEntity; 
	}

}
