package com.myboard.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String addr;
	private Date regdate;
}
