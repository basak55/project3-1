package com.bori.project31.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mno;
	private String mid;
	private String mpw;
	private String name;
	private String gender;
	@Column(columnDefinition = "Integer default 0")
	private Integer exp;
	private String mintro;
}
