package com.myboard.mapper;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentMapper {
	// comment 추가
	public void insert(CommentDTO comment);

	// comment 전체보기
	public List<CommentDTO> getList(int bnum);

	// comment 댓글삭제
	public void delete(int cnum);
	
	//read
	public CommentDTO read(int cnum);
}
