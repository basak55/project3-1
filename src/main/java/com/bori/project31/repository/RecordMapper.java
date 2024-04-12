package com.bori.project31.repository;

import com.bori.project31.model.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface RecordMapper {

	@Update("UPDATE record SET visit=visit+1 WHERE mno=#{mno}")
	public void updateVisit(int mno); //방문횟수 -> 로그인할때 증가
	
	public void questcntUpdate(int mno); //quest수 +1

	@Update("UPDATE Record SET rno=rno+1 WHERE mno=#{mno}")
	public void updateRno(int mno);

	@Insert("INSERT INTO Record(mno) VALUES(#{mno})")
	public void insertRecord(int mno);

	@Select("SELECT * FROM Record")
	public List<Record> selectRecord();
}
