package com.mycom.myapp06;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.CommentDTO;
import com.myboard.dto.MemberDTO;
import com.myboard.model.CommentService;

@RequestMapping("/reply/*")
@RestController //@Controller + @ResponseBody
public class CommentController {
	@Autowired //생성된 객체를 주입  트랜잭션 할 경구 impl 하면 안댐
	private CommentService cservice;
	
	//댓글 추가
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentDTO comment,	HttpSession session) {
		String id = ((MemberDTO)session.getAttribute("sMember")).getId();
		comment.setUserid(id);
		cservice.insert(comment);
		
		return "success";
	}
	//댓글리스트
	@GetMapping("commentList")
	public List<CommentDTO> getList(int bnum){
		return cservice.getList(bnum);
	}
	//댓글 삭제
	@DeleteMapping("del/{cnum}")
	@ResponseBody
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;
	}
}
