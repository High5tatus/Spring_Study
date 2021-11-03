package com.myguest.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.myguest.model.GuestDTO;

public interface GuestMapper {
	//추가
	@Insert("insert into guest(name,content,grade,ipaddr) values(#{name},#{content},#{grade},#{ipaddr})")
	public void insert(GuestDTO guest);
	//전체보기
	public List<GuestDTO> guest_list(HashMap<String, String> hm);
	
	//상세보기
	@Select("select * from guest where num=#{num}")
	public GuestDTO findByNum(int num);
	//수정
	public void updqte(GuestDTO guest);
	//삭제
	@Delete("delete from guest where num=#{num}")
	public void delete(int num);
	//개수
	public int guest_count(HashMap<String, String> hm);
	
	
///////
	@Select("select * from guest")
	public List<GuestDTO> list();
	
	@Select("select count(*) from guest")
	public int count();
}
