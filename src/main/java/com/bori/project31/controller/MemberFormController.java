package com.bori.project31.controller;

import javax.servlet.http.HttpSession;

import com.bori.project31.model.LoginRequest;
import com.bori.project31.model.Member;
import com.bori.project31.model.MemberRank;
import com.bori.project31.model.MemberRequest;
import com.bori.project31.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberFormController {
	
	@Autowired
	MemberInfoService memberInfoService;
	

	//회원가입 페이지
	@GetMapping("/signUp")
	public String signUp() {
		return "/th/signUp";
	}
	
	//회원 가입  
	@PostMapping("/member")
	public String insertMember(MemberRequest req) {
		Member member = new Member(req.getMid(), req.getMpw(), req.getName(), req.getGender(), req.getMintro());
		memberInfoService.insertMember(member);
		return "/th/signupAlert";
	}
	
	//로그인 페이지
	@GetMapping("/login")
	public String login() {
		return "/th/loginForm";
	}
	
	//로그인 체크
	@PostMapping("/loginCheck")
	public String loginCheck(LoginRequest logReq, Model model, HttpSession session) {
		int loginStatus = memberInfoService.login(logReq);
		String id = logReq.getMid();
		if(loginStatus > 0) { //로그인 성공시 mno반환
			session.setAttribute("loginId", logReq.getMid()); //세션에 Mid 저장
			session.setAttribute("mno", loginStatus);
			return "index";
		} else if (loginStatus <= 0){ // 0~-2
			return "redirect:/login?loginStatus="+loginStatus; //로그인 실패 원인 코드 반환..할까?
		}
		return "redirect:/login?loginStatus="+loginStatus;
	}

	@GetMapping("/rank")
	public String rank(Model model){
		List<MemberRank> list = memberInfoService.selectMemberRank();
		model.addAttribute("list", list);
		return "/th/rankList";
	}

	@GetMapping("/guest")
	public String guestbook(@RequestParam(name = "mno", required = false) Integer mno, Model model){
		model.addAttribute("info",memberInfoService.selectRankByMno(mno));
		return "/th/guestBook";
	}
}
