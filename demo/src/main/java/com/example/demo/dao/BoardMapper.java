package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.BoardDTO;

@Mapper
public interface BoardMapper {
	public List<BoardDTO> list();//전체보기
	public void insert(BoardDTO board);//추가
	public int count();
	public BoardDTO findByNum(int num);//상세보기
	public void update(BoardDTO board);
	public void delete(int num);
	//public void updateReplyCnt(HashMap<String, Integer> hm);
	public void updateReplyCnt(@Param("bnum") int bnum, @Param("amount") int amount);
}
