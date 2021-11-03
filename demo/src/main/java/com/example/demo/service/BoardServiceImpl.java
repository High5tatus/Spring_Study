package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardMapper;
import com.example.demo.vo.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{
@Autowired
private BoardMapper bmapper;
	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return bmapper.list();
	}

	@Override
	public void insert(BoardDTO board) {
		// TODO Auto-generated method stub
		bmapper.insert(board);
	}

	@Override
	public BoardDTO findByNum(int num) {
		// TODO Auto-generated method stub
		return bmapper.findByNum(num);
	}

	@Override
	public void update(BoardDTO board) {
		// TODO Auto-generated method stub
		bmapper.update(board);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		bmapper.delete(num);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return bmapper.count();
	}

}
