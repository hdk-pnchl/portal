package com.draakasheeshah.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.draakasheeshah.business.bo.UserEntity;
import com.draakasheeshah.business.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Is working fine");
		try {
			response.getWriter().write("UserController Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	public @ResponseBody UserEntity getById(@RequestParam("userId") long userId) {
		logger.info("Getting: " + userId);
		UserEntity user = userService.get(userId);
		return user;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody UserEntity get(@RequestBody UserEntity user) {
		logger.info("Getting: " + user);
		user = userService.get(user);
		return user;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody UserEntity save(@RequestBody UserEntity user) {
		logger.info("Saving: " + user);
		user = userService.save(user);
		return user;
	}

	@RequestMapping(value = "/updating", method = RequestMethod.POST)
	public @ResponseBody UserEntity update(@RequestBody UserEntity user) {
		logger.info("Updating: " + user);
		user = userService.update(user);
		return user;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<UserEntity> getAll() {
		List<UserEntity> patientList = userService.getAll();
		return patientList;
	}	
}
