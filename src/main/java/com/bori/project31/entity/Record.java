package com.bori.project31.entity;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Record {

	@Id
	private Integer mno;
	@Column(columnDefinition = "int default 0")
	private Integer rno;
	@Column(columnDefinition = "int default 0")
	private Integer playtime;
	@Column(columnDefinition = "int default 0")
	private Integer visit;
	@Column(columnDefinition = "int default 0")
	private Integer questcount;
	
}
