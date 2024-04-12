package com.bori.project31.repository;

import com.bori.project31.model.Member;
import com.bori.project31.model.MemberRank;
import com.bori.project31.model.MemberRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

	public List<MemberRank> selectMemberRank();
	public MemberRank selectRankByMno(int mno);
	public boolean countMemberById(String mid);	//아이디 중복체크

	public void updateExp1(int mno);				//경험치관리 (레벨)
	public void updateExp2(int mno);				//경험치관리 (레벨)
	public int updateMember(Member member);		//회원정보 수정
	
	public void insertMember(Member member);		//회원가입
	
	public Member selectById(String mid);		//아이디검색 (로그인)
	public Member selectByMno(int mno);			//회원정보 조회
}
