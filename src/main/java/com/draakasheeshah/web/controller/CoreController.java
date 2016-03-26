package com.draakasheeshah.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/core")
public class CoreController implements ResourceLoaderAware {

	private static final Logger logger = Logger.getLogger(CoreController.class);

	private ResourceLoader resourceLoader;

	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		logger.info("test:");
		System.out.println("/core" + " : " + "/test");
		try {
			response.getWriter().write("Patient saied: Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/getBannerTest", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBannerTest() throws IOException {
		System.out.println("/core" + " : " + "/getBannerTest");

		Map<String, Object> userData = new HashMap<String, Object>();
		userData.put("one", "test");

		return userData;
	}

	/**
	 * http://localhost:8080/portal/ctrl/core/getBanner
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getBanner", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBanner() throws IOException {
		logger.info("getBanner:");

		Resource bannerDataJson = this.resourceLoader.getResource("classpath:data/json/bannerData.json");
		Map<String, Object> userData = objectMapper.readValue(bannerDataJson.getFile(), Map.class);
		logger.info(userData);

		return userData;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
}
