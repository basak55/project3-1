package com.bori.project31.controller;

import com.bori.project31.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MemberController {
	
	//RestController니까 ajax 사용 용도의 서비스만 매핑하면 될듯?
	
	@Autowired
	MemberInfoService memberInfoService;
	
	
	//아이디 중복 조회
	@PostMapping("/checkId")
	public boolean checkId(@RequestParam String mid) {
		return memberInfoService.countMemberById(mid);
	}



	

	
}
