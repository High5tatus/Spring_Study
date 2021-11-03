package com.mysecurity.mapper;

import java.util.List;

import com.mysecurity.dto.BoardDTO;


public interface BoardMapper {
	// 추가
	public void insert(BoardDTO board);
	
	//전체보기
	public List<BoardDTO> findAll(); 
}
