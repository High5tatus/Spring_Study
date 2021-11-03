package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.BoardDTO;

public interface BoardService {
	public List<BoardDTO> list();//전체보기
	public void insert(BoardDTO board);//추가
	public BoardDTO findByNum(int num);//상세보기
	public void update(BoardDTO board);//수정
	public void delete(int num);//삭제
	public int count(); //개수
	
}
