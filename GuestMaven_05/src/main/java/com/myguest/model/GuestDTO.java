package com.myguest.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GuestDTO {
	private int num;
	private String name;
	private String content;
	private String grade;
	private String created;
	private String ipaddr;
}
