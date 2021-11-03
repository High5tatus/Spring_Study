package com.mytest.model;

import java.util.HashMap;
import java.util.List;

import com.mytest.dto.BoardDTO;


public interface BoardDAO {
	// 추가
	public void dao_insert(BoardDTO board);

	// 전체보기
	public List<BoardDTO> dao_findAll(HashMap<String, Object> hm);

	// 상세보기
	public BoardDTO dao_findByNum(int num);

	// 수정
	public void dao_update(BoardDTO board);

	// 삭제
	public void dao_delete(int num);

	// 개수
	public int dao_getCount(HashMap<String, Object> hm);
}
