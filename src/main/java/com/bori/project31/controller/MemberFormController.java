package com.bori.project31.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bori.project31.model.LoginRequest;
import com.bori.project31.model.Member;
import com.bori.project31.model.MemberRank;
import com.bori.project31.model.MemberRequest;
import com.bori.project31.service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberFormController {
	
	@Autowired
	MemberInfoService memberInfoService;
	

	//회원가입 페이지
	@GetMapping("/signUp")
	public String signUp() {
		return "/th/signUp";
	}
	
	//회원 가입  
	@PostMapping("/signUpMember")
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
	@PostMapping("/login")
	@ResponseBody
	public Member loginCheck(LoginRequest logReq, Model model, HttpServletRequest request) {
		//로그인 정보 체크
		String loginId = logReq.getMid();
		String loginPw = logReq.getMpw();
		Member member = memberInfoService.login(logReq);

		//세션에 회원 정보 저장, 세션 유지 시간 설정
		if(member != null) { 
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", member);
			session.setMaxInactiveInterval(60*30);
//			System.out.println(session.getAttribute("loginMember"));
		}
		return member;
	}

	//로그아웃
	@PostMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/th/loginForm";
	}

	//랭킹 리스트
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
