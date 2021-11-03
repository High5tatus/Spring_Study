package com.example.simple_board.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Board {
	@Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long num;
	private String title;
	private String content;
	
}
