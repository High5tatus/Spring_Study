package com.example.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Todo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String subject;
	private String name;
	private String summary;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="regdate")
	@JsonFormat(shape=Shape.STRING,pattern="yyyy-MM-dd",timezone = "Asia/Seoul")
	private Date regdate;
}
