package com.example.demo.controller;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.domain.Member;
import com.example.demo.model.dto.AddMemberRequest;
import com.example.demo.model.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/members")
    public String addmembers(@ModelAttribute AddMemberRequest request) {
        memberService.saveMember(request);
        return "join_end"; 
    }

    @PostMapping("/api/login_check")
    public String checkMembers(@ModelAttribute AddMemberRequest request, Model model, HttpServletRequest request2, HttpServletResponse response) {
        try {

            HttpSession session = request2.getSession(false);
            if (session != null) {
                session.invalidate();
                Cookie cookie = new Cookie("JSESSIONID", null);
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

            session = request2.getSession(true);

            Member member = memberService.loginCheck(request.getEmail(), request.getPassword());
            

            String sessionId = UUID.randomUUID().toString();
            session.setAttribute("userId", sessionId);
            session.setAttribute("email", member.getEmail());

            return "redirect:/board_list";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

    @GetMapping("/api/logout")
    public String member_logout(HttpServletRequest request2, HttpServletResponse response) {
        HttpSession session = request2.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "login";
    }
    

    @GetMapping("/member_login")
    public String loginPage() {
        return "login";
    }


    @GetMapping("/member_join")
    public String joinPage() {
        return "join";
    }
}