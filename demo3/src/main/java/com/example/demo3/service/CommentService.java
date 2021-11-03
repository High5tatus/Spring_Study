package com.example.demo3.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo3.model.Board;
import com.example.demo3.model.Comment;
import com.example.demo3.model.User;
import com.example.demo3.repository.BoardRepository;
import com.example.demo3.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	private final CommentRepository commentRepository;
	private final BoardRepository boardRepository;
	//댓글쓰기
	@Transactional
	public void insert(Comment comment) {
		//board의 replycnt 1증가
//		Optional<Board> b=  boardRepository.findById(comment.getBoard().getNum());
//		b.get().setReplycnt(b.get().getReplycnt()+1);
		Board b=  boardRepository.findById(comment.getBoard().getNum()).get();
		b.setReplycnt(b.getReplycnt()+1);
		//댓글추가		
		//commentRepository.save(comment);
		
		//JPQL
		commentRepository.commentInsert(
				comment.getContent(),
				comment.getBoard().getNum(),
				comment.getUser().getId()
				);
	}
	//댓글 보기
	public List<Comment> list(Long bnum) {
		return commentRepository.findByBnum(bnum);
	}
	//덧글 삭제
	@Transactional
	public void delete(Long cnum) {		
		Comment c = commentRepository.findByCnum(cnum);
		Board b=  boardRepository.findById(c.getBoard().getNum()).get();
		b.setReplycnt(b.getReplycnt()-1);
		
		commentRepository.deleteByCnum(cnum);
	}
}
