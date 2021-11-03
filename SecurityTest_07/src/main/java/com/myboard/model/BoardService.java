package com.myboard.model;

import java.util.List;

import com.mysecurity.dto.BoardDTO;

public interface BoardService {
	// 추가
	public void insert(BoardDTO board);

	// 전체보기
	public List<BoardDTO> list();

}
