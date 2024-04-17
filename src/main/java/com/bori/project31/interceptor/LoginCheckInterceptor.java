package com.bori.project31.interceptor;

import com.bori.project31.model.Member;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //세션에서 회원정보 조회하기
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("loginMember");

        //회원 정보 체크
        if(member == null){
            response.sendRedirect("/th/loginForm");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
