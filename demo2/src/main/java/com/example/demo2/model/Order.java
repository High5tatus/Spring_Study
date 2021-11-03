package com.example.demo2.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="tbl_order")
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderid;
	private String ordername;
	private String note;
	private int price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
}
