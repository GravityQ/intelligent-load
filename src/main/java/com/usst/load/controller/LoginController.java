package com.usst.load.controller;

import com.usst.load.model.User;
import com.usst.load.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * @author junlin.qi on 2018/9/15
 */
@Controller
@Slf4j
public class LoginController {
	@Inject
	private UserService userService;
	/**
	 * 登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request) {
		User selectUser = userService.select(user);
		if (selectUser!=null) {
			request.getSession().setAttribute("user",selectUser);
			return "home";
		}
		return "login";
	}
}
