package com.bori.project31.controller;

import com.bori.project31.model.CheckRequest;
import com.bori.project31.model.GameRequest;
import com.bori.project31.model.Sentence;
import com.bori.project31.service.MemberRecordService;
import com.bori.project31.service.RandomSentService;
import com.bori.project31.service.TypoCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class GameController {
	
	@Autowired
	TypoCheckService typoCheckService;
	@Autowired
	MemberRecordService memberRecordService;
	@Autowired
	RandomSentService randomSentService;

	
//	@PostMapping("/check")
//	public String typoCheck( CheckRequest checkReq) {
//		System.out.println("checkReq: "+checkReq);
//		memberRecordService.questcntUpdate(checkReq.getMno()); 	//Record>questcnt증가
//		Sentence sentence = randomSentService.selectForGame();	//randomSentence 출력
//		boolean result = typoCheckService.typoCheck(checkReq);	//오타 체크
//		if (result) {
//			memberRecordService.updateExp1(checkReq.getMno());
//		} else if (!result) {
//			memberRecordService.updateExp2(checkReq.getMno());
//		}
//		return sentence.getWriter();
//	}
//
	@GetMapping("/endGame")
	public int endGame(@RequestParam int playTime) {
		return playTime;
	}
	

}
