package com.example.demo3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo3.model.Comment;
import com.example.demo3.model.User;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	@Modifying
	@Query(value="insert into tbl_comment3(content, regdate, bnum, user_id) values(?1,now(),?2,?3)",nativeQuery = true)
	public void commentInsert(String content, Long bnum, Long user_id); 

	//Board.java에서 user 가 @ManyToOne(fetch = FetchType.Eager)
	//@Query("select sc from tbl_comment3 sc where bnum=?1")
	
	//LAZY를 사용시 아래 사용
	@Query("select sc from tbl_comment3 sc join fetch sc.board where bnum=?1")
	public List<Comment> findByBnum(Long bnum);
	
	public void deleteByCnum(Long cnum);
	
	Comment findByCnum(Long cnum);
}
