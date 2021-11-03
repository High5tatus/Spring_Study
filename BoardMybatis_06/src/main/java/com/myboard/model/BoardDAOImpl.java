package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.dto.BoardDTO;
import com.myboard.mapper.BoardMapper;
@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private BoardMapper bmapper;
	
	public void dao_readCount(int num) {
		bmapper.readCount(num);
	}
	
	@Override
	public void dao_insert(BoardDTO board) {
		bmapper.insert(board);
		
	}

	@Override
	public List<BoardDTO> dao_findAll(HashMap<String, Object> hm) {
		return bmapper.findAll(hm);
	}

	@Override
	public BoardDTO dao_findByNum(int num) {
		return bmapper.findByNum(num);
	}

	@Override
	public void dao_update(BoardDTO board) {
		bmapper.update(board);
		
	}

	@Override
	public void dao_delete(int num) {
		bmapper.delete(num);
	}

	@Override
	public int dao_getCount(HashMap<String, Object> hm) {
		
		return bmapper.getCount(hm);
	}

}
