package com.bori.project31.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CheckRequest {

	private String inputText;
	private String quest; // Sentence
	private int mno;

}
