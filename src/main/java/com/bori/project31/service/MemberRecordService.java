package com.bori.project31.service;

import com.bori.project31.repository.MemberMapper;
import com.bori.project31.repository.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberRecordService{

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	RecordMapper recordMapper;
	
	public void expCheck() {
		
	}
	
	//경험치 업데이트 (정답)
	public void updateExp1(int mno) {
		memberMapper.updateExp1(mno);
	}
	//경헙치 업데이트 (오답)
	public void updateExp2(int mno) {
		memberMapper.updateExp1(mno);
	}
	
	//진행 퀘스트 +1
	public void questcntUpdate(int mno) {
		recordMapper.questcntUpdate(mno);
	}
	
}
