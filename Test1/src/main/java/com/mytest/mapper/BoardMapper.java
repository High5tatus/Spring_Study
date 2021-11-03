package com.mytest.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mytest.dto.BoardDTO;


public interface BoardMapper {
	// 추가
	public void insert(BoardDTO board);

	// 전체보기
	public List<BoardDTO> findAll(HashMap<String, Object> hm);

	// 상세보기
	public BoardDTO findByNum(int num);

	// 수정
	public void update(BoardDTO board);

	// 삭제
	public void delete(int num);

	// 개수
	public int getCount(HashMap<String, Object> hm);

	//조회수 증가
	public void readCount(int num);
	
	//replyCnt 개수 증가
	public void updateReplyCnt(@Param("bnum") int bnum,@Param("amount") int amount);
	
}
