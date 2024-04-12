package com.bori.project31.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class Record {

	private Integer mno;
	private Integer rno;
	private Integer playtime;
	private Integer visit;
	private Integer questcount;
}
