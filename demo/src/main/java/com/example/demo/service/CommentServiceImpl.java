package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.BoardMapper;
import com.example.demo.dao.CommentMapper;
import com.example.demo.vo.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper cmapper;
	@Autowired
	private BoardMapper bmapper;

	@Override
	@Transactional
	public void insert(CommentDTO comment) {
		// TODO Auto-generated method stub
		cmapper.insert(comment);
//		HashMap<String, Integer> hm = new HashMap<String, Integer>();
//		hm.put("bnum", comment.getBnum());
//		hm.put("amount", 1);
//		bmapper.updateReplyCnt(hm);
		bmapper.updateReplyCnt(comment.getBnum(),1);
	}

	@Override
	public List<CommentDTO> getList(int bnum) {
		// TODO Auto-generated method stub
		return cmapper.getList(bnum);
	}

	@Override
	@Transactional
	public void delete(int cnum) {
		// TODO Auto-generated method stub
		CommentDTO comment = cmapper.findByNum(cnum);
		bmapper.updateReplyCnt(comment.getBnum(), -1);
		cmapper.delete(cnum);
		
	}

}
