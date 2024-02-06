package com.study.study_project.controller;

import com.study.study_project.domain.dto.UserDTO;
import com.study.study_project.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user/*")
public class UserController {
	@Autowired
	private UserService service;
//	GET
//	/user/login		로그인 페이지로 이동					
//	/user/join		회원가입 페이지로 이동
//	/user/checkid	넘겨진 파라미터로 아이디 중복 체크
//	/user/logout	로그아웃 처리
//	
//	POST
//	/user/login		넘겨진 파라미터로 로그인 처리
//	/user/join		넘겨진 데이터들로 회원가입 처리

	@GetMapping("join")
	public void replace() {}

	@PostMapping("join")
	public String join(UserDTO user, RedirectAttributes ra) {
		if(service.join(user)) {
			ra.addAttribute("joinid",user.getUserid());
		}
		return "redirect:/";
	}
	@GetMapping("login")
	public void replaceLogin(){}

	@PostMapping("login")
	public String login(String loginMail, String loginPw, HttpServletRequest req) {
		System.out.println(loginMail + loginPw);
		UserDTO loginUser = service.login(loginMail, loginPw);
		if(loginUser != null) {
			req.getSession().setAttribute("loginUser", loginUser.getUserid());
			return "redirect:/";
		}
		else {
			return "redirect:/";
		}
	}

	@GetMapping("logout")
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/";
	}

	@GetMapping("checkid")
	@ResponseBody
	public String checkId(String userid) {
		if(service.checkId(userid)) {
			return "O";
		}
		return "X";
	}
}











