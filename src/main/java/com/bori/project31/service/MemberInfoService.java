package com.bori.project31.service;

import com.bori.project31.model.LoginRequest;
import com.bori.project31.model.Member;
import com.bori.project31.model.MemberRank;
import com.bori.project31.model.MemberRequest;
import com.bori.project31.repository.MemberMapper;
import com.bori.project31.repository.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class MemberInfoService {

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	RecordMapper recordMapper;
	
	//회원가입 (member + record)
	@Transactional
	public void insertMember(Member member) {
		memberMapper.insertMember(member);
		int mno = member.getMno();
		recordMapper.insertRecord(mno);
	}
	
	//중복아이디 조회
	public boolean countMemberById(String mid) {
		return memberMapper.countMemberById(mid);
	}
	
	//회원정보 수정
	public int updateMember(Member member) {
		memberMapper.updateMember(member);
		return member.getMno();
	}
	
	//회원정보 조회
	public Member selectByMno(int mno) {
		Member member = memberMapper.selectByMno(mno);
		return member;
	}
	
	//로그인 -> 방문횟수 증가
	public int login(LoginRequest logReq) {
		//입력한 id로 회원정보 확인
		Member member = memberMapper.selectById(logReq.getMid());
		if(member == null) { //존재하지 않는 아이디
			return 0;
		}
		if(!member.getMpw().equals(logReq.getMpw())) { // 잘못된 비밀번호
			return -1;
		} else if(member.getMid().equals(logReq.getMid()) && member.getMpw().equals(logReq.getMpw())){
			recordMapper.updateVisit(member.getMno()); // 방문횟수 증가
			return member.getMno(); // 로그인 성공
		}	
		return -2; //기타 오류
	}

	//게임 판수 증가 (Rno)
	public void updateRno(int mno){
		recordMapper.updateRno(mno);
	}

	//랭크리스트
	public List<MemberRank> selectMemberRank(){
		return memberMapper.selectMemberRank();
	}

	//방명록 정보
	public MemberRank selectRankByMno(int mno){
		return memberMapper.selectRankByMno(mno);
	}

	

}
