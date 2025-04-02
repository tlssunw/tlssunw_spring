package com.talk.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talk.Dto.BoardDetailDto;
import com.talk.Dto.BoardDto;
import com.talk.Dto.BoardListDto;
import com.talk.Entity.BoardEntity;
import com.talk.Repository.BoardRepository;
import com.talk.Repository.CommentRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	//게시글 저장
	public void boardSave(BoardDto boardDto) {
		
	}
	//게시글 삭제
	public void boardDelete(int id) {
		
	}
	//게시글 수정
	public void boardUpdate(BoardDto boardDto) {
		
	}
	//게시글 상세보기
	public BoardDetailDto boardDetail(int id) {
		return null;
	}
	//게시글 목록
	public List<BoardListDto> boardList(int id){
		return null;
	}
	//게시글 전체 갯수
	public int boardCount() {
		return 0;
	}
	//최근글(5개)
	public List<BoardListDto> boardRecent(){
		//데이터베이스 테이블(엔티티)에서 가져옴
		List<BoardEntity> boardEntities = boardRepository.findByOrderByWriteDateDesc();
		
		//반환타입<boardListDto>의 객체를 만들어줌 (디티오에 넘김)
		List<BoardListDto> boardListDtos = new ArrayList<>();
		
		for(BoardEntity board : boardEntities) {
			BoardListDto dto = BoardListDto.from(board);
			boardListDtos.add(dto);
		}
		
		return boardListDtos;
	}
	//인기글
	public List<BoardListDto> boardPupular(){
		//데이터베이스 테이블(엔티티)에서 가져옴
		List<BoardEntity> boardEntities = boardRepository.findByOrderByHitDesc();
		
		//반환타입<boardListDto>의 객체를 만들어줌 (디티오에 넘김)
		List<BoardListDto> boardListDtos = new ArrayList<>();
		
		for(BoardEntity board : boardEntities) {
			BoardListDto dto = BoardListDto.from(board);
			boardListDtos.add(dto);
		}
		
		return boardListDtos;
	}

}
