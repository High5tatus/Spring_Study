package com.example.simple_board.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple_board.model.Board;
import com.example.simple_board.repository.BoardRepository;


@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRep;
	public void insert(Board board) {
		boardRep.save(board);
	}
	public List<Board> findAll(){
		return boardRep.findAll();
	}
	public List<Board> findBySubject(String title){
		return boardRep.findByTitleContaining(title);
	}
	public void delete(Long num) {
		boardRep.deleteById(num);
	}
	public Optional<Board> view(Long num) {		
		return boardRep.findById(num);
	}
	@Transactional
	public void update(Board board) {
		Board bo = boardRep.findById(board.getNum()).get();
		bo.setContent(board.getContent());
		bo.setTitle(board.getTitle());
	}
}
