package com.bori.project31.controller;

import com.bori.project31.model.CheckRequest;
import com.bori.project31.model.CommentRequest;
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

	
	@PostMapping("/game/{mno}/check")
	public Boolean typoCheck(@PathVariable final int mno, @RequestBody final CheckRequest params) {
		System.out.println("checkReq: "+params);
		memberRecordService.questcntUpdate(mno); 	//Record>questcnt증가
		boolean result = typoCheckService.typoCheck(params);	//오타 체크 및 경험치 증량

		if (result) {
			memberRecordService.updateExp1(mno);
		} else if (!result) {
			memberRecordService.updateExp2(mno);
		}
		return result; //check 결과 반환
	}

	@PostMapping("/game/{mno}/new")
	public Sentence newSentence(@PathVariable final int mno){
		return randomSentService.selectForGame();
	}



	@GetMapping("/endGame")
	public int endGame(@RequestParam int playTime) {
		return playTime;
	}
	

}
