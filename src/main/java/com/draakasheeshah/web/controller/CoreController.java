package com.draakasheeshah.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.service.BasicDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/core")
public class CoreController implements ResourceLoaderAware {

	private static final Logger logger = Logger.getLogger(CoreController.class);

	private ResourceLoader resourceLoader;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private BasicDetailService basicDetailService;

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
	@RequestMapping(value = "/getBannerData", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getBannerData() throws IOException {
		Resource bannerJson = null;
		if (this.isAuth()) {
			bannerJson = this.resourceLoader.getResource("classpath:data/json/bannerData.json");
		} else {
			bannerJson = this.resourceLoader.getResource("classpath:data/json/bannerDataGuest.json");
		}
		Map<String, Object> bannerData = objectMapper.readValue(bannerJson.getFile(), Map.class);
		logger.info("getBannerData: " + bannerData);

		return bannerData;
	}

	/**
	 * http://localhost:8080/portal/ctrl/core/getBanner
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getPatientColumnData", method = RequestMethod.GET)
	public @ResponseBody List<Object> getPatientColumnData() throws IOException {
		Resource patientColumnJson = this.resourceLoader.getResource("classpath:data/json/patientColumnData.json");
		List<Object> patientColumnData = objectMapper.readValue(patientColumnJson.getFile(), List.class);
		logger.info("getPatientColumnData: " + patientColumnData);

		return patientColumnData;
	}

	/**
	 * http://localhost:8080/portal/ctrl/core/getPatientWizzardData
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getPatientWizzardData", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPatientWizzardData() throws IOException {
		Resource patientWizzardJson = this.resourceLoader.getResource("classpath:data/json/patientWizzard.json");
		Map<String, Object> patientWizzardData = objectMapper.readValue(patientWizzardJson.getFile(), Map.class);
		logger.info("getPatientWizzardData: " + patientWizzardData);

		return patientWizzardData;
	}

	/**
	 * http://localhost:8080/portal/ctrl/core/signUp
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public @ResponseBody PatientEntity signUp(@RequestBody BasicDetailEntity basicDetail) throws IOException {
		PatientEntity patientEntity = basicDetailService.saveWithPatient(basicDetail);
		logger.info("getPatientWizzardData: " + patientEntity);
		return patientEntity;
	}

	// --- private

	private boolean isAuth() {
		boolean isAuth = false;
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			isAuth = true;
		}
		return isAuth;
	}

	// --- setter getter

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
}
