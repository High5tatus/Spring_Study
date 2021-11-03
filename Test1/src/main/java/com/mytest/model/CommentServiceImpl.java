package com.mytest.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mytest.dto.CommentDTO;
import com.mytest.mapper.BoardMapper;
import com.mytest.mapper.CommentMapper;


@Service
public class CommentServiceImpl implements CommentService{
@Autowired
private CommentMapper cmapper;
@Autowired
private BoardMapper bmapper;

	@Transactional //커밋을 하던 롤백을 하던 하나의 작업단위로 동작
	@Override
	public void insert(CommentDTO comment) {
		cmapper.insert(comment);
		//board의 replyCnt 증가
		bmapper.updateReplyCnt(comment.getBnum(), 1);
	}

	@Override
	public List<CommentDTO> getList(int bnum) {
		
		return cmapper.getList(bnum);
	}
	@Transactional 
	@Override
	public void delete(int cnum ) {
		CommentDTO comment = cmapper.read(cnum);
		cmapper.delete(cnum);
		bmapper.updateReplyCnt(comment.getBnum(), -1);
	}

}
