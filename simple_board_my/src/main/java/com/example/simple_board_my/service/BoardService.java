package com.example.simple_board_my.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple_board_my.dto.BoardDTO;
import com.example.simple_board_my.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private BoardMapper bmapper;
	
	//추가
	public void insert(BoardDTO board) {
		bmapper.insert(board);
	}
	//전체보기
	public List<BoardDTO> findAll(){
		return bmapper.findAll();
	}
	
}
