package com.bori.project31.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class MemberRequest {

	private String mid;
	private String mpw;
	private String name;
	private String gender;
	private String mintro;
}
