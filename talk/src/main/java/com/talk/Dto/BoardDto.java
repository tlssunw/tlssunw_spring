package com.talk.Dto;

import com.talk.Entity.BoardEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
	private int id;
	private String title;
	private String content;
	private String fileName;
	
	public static BoardEntity to(BoardDto boardDto) {
		BoardEntity boardEntity = new BoardEntity();
		
		boardEntity.setId(boardDto.getId());
		boardEntity.setTitle(boardDto.getTitle());
		boardEntity.setContent(boardDto.getContent());
		boardEntity.setFileName(boardDto.getFileName());
		
		return boardEntity;
	}
	
	public static BoardDto from(BoardEntity boardEntity) {
		BoardDto boardDto = new BoardDto();
		
		return boardDto;
	}

}
