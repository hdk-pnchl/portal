package com.draakasheeshah.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/core")
public class CoreController {

	@Autowired
	ObjectMapper objectMapper;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/core" + " : " + "/test");
		try {
			response.getWriter().write("Patient saied: Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getBanner", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBanner() throws IOException {
		System.out.println("/core" + " : " + "/test");
		@SuppressWarnings("unchecked")
		Map<String, Object> userData = objectMapper.readValue(new File("classpath:static/data/json/bannerData.json"), Map.class);
		return userData;
	}
}
