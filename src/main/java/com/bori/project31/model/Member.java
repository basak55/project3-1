package com.bori.project31.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Member {
	
	private int mno;
	private String mid;
	private String mpw;
	private String name;
	private String gender;
	private int exp;
	private String mintro;

	public Member(String mid, String mpw, String name, String gender, String mintro) {
		this.mid = mid;
		this.mpw = mpw;
		this.name = name;
		this.gender = gender;
		this.mintro = mintro;
	}

	public Member(String mid) {
		super();
		this.mid = mid;
	}

	public void clearMpw(){
		this.mpw="";
	}
	
	
}

