package com.example.demo2.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hotel_review")
public class Review {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int rate;
	private String comment;
	private Date ratingDate;
	@JoinColumn(name="hotel_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Hotel hotel;
}
