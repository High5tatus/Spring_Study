package com.example.demo3.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo3.model.Board;
import com.example.demo3.model.User;
import com.example.demo3.repository.BoardRepository;
@Transactional(readOnly = true)
@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	//추가
	@Transactional
	public void insert(Board board, User user) {
		board.setUser(user);
		boardRepository.save(board);
	}
	//보기
	public List<Board> list() {
		return boardRepository.findAll();
	}
	//게시글 개수
	public Long count(){
		return boardRepository.count();
	}
	@Transactional
	//상세보기
	public Board findById(Long num) {
		Board board = boardRepository.findById(num).get();
		board.setHitcount(board.getHitcount()+1);
		return board;
	}
	
	//수정하기
	@Transactional
	public void update(Board board) {
		Board b = boardRepository.findById(board.getNum()).get();
		b.setTitle(board.getTitle());
		b.setContent(board.getContent());
	}
	//삭제
	@Transactional
	public void delete(Long num) {
		//boardRepository.deleteById(num);;
		boardRepository.deleteByNum(num);
	}
	//전체보기 페이징
	public Page<Board> findAll(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
}
