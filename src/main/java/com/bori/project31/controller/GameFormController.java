package com.bori.project31.controller;

import com.bori.project31.model.CheckRequest;
import com.bori.project31.model.Sentence;
import com.bori.project31.service.MemberInfoService;
import com.bori.project31.service.MemberRecordService;
import com.bori.project31.service.RandomSentService;
import com.bori.project31.service.TypoCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GameFormController {
	
	@Autowired
	RandomSentService randomSentService;
	@Autowired
	MemberInfoService memberInfoService;
	@Autowired
	TypoCheckService typoCheckService;
	@Autowired
	MemberRecordService memberRecordService;
	

	@GetMapping("/")
	public String index() {
		return "index";
	}

	
	@GetMapping("/game")
	public String game(Model model) {
		model.addAttribute("sent", randomSentService.selectForGame());
		int mno = 1; //rno 증가 테스트용!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!값 받아오는걸로 바꾸기
		memberInfoService.updateRno(mno);
		return "game";
	}

	@PostMapping("/check")
	public String typoCheck(CheckRequest checkReq, Model model) {
		System.out.println("checkReq: "+checkReq);
		memberRecordService.questcntUpdate(checkReq.getMno()); 	//Record>questcnt증가
		Sentence sentence = randomSentService.selectForGame();	//randomSentence 출력
		boolean result = typoCheckService.typoCheck(checkReq);	//오타 체크
		model.addAttribute("result", result);		//오타 체크 result 전달
		if (result) {
			memberRecordService.updateExp1(checkReq.getMno());
		} else if (!result) {
			memberRecordService.updateExp2(checkReq.getMno());
		}
		return "redirect:/game?result=" + result;
	}
	
}
