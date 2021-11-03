package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.CommentDTO;

@Mapper
public interface CommentMapper {
	public List<CommentDTO> getList(int bnum);
	public void insert(CommentDTO comment);
	public CommentDTO findByNum(int cnum);
	public void delete(int cnum);
}
