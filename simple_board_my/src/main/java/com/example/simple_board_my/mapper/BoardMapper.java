package com.example.simple_board_my.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.simple_board_my.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	// 추가
		public void insert(BoardDTO board);

		// 전체보기
		public List<BoardDTO> findAll();

}
