package com.draakasheeshah.web.controller;

import java.io.IOException;
import java.util.Collection;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.MessageEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.bo.ResponseEntity;
import com.draakasheeshah.business.service.BasicDetailService;
import com.draakasheeshah.business.service.MessageService;
import com.draakasheeshah.business.util.CommonUtil;
import com.draakasheeshah.business.util.Roles;
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

	@Autowired
	private MessageService messageService;

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

	// -------------------------DATA------------------------

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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (this.isAuth(auth)) {
			Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) auth.getAuthorities();
			if (CommonUtil.isAdmin(authorities)) {
				bannerJson = this.resourceLoader.getResource("classpath:data/json/bannerData.json");
			} else {
				bannerJson = this.resourceLoader.getResource("classpath:data/json/bannerDataMember.json");
			}
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

	// -------------------------BUSINESS------------------------

	/**
	 * http://localhost:8080/portal/ctrl/core/signUp
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public @ResponseBody PatientEntity signUp(@RequestBody BasicDetailEntity basicDetail) throws IOException {
		logger.info("Singup DATA : " + basicDetail.getName() + "::::" + basicDetail.getPatientPassword() + "::::"
				+ basicDetail.getEmailId());

		PatientEntity patientEntity = basicDetailService.saveWithPatient(basicDetail);
		logger.info("getPatientWizzardData: " + patientEntity);
		return patientEntity;
	}

	/**
	 * http://localhost:8080/portal/ctrl/core/isEmailIdTaken?emailId=hdk.
	 * pnchl@gmail.com
	 * 
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/isEmailIdTaken", method = RequestMethod.POST)
	public @ResponseBody Map<String, Boolean> isEmailIdTaken(@RequestParam("emailId") String emailId) {
		BasicDetailEntity basicDetail = basicDetailService.get(emailId);
		Map<String, Boolean> responseMap = new HashMap<String, Boolean>();
		responseMap.put("isEmailIdTaken", (basicDetail != null) ? true : false);
		return responseMap;
	}

	@RequestMapping(value = "/saveMessage", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity saveMessage(@RequestBody MessageEntity message) {
		System.out.println("/Core" + " : " + "/save");
		message = messageService.save(message);
		ResponseEntity response = new ResponseEntity();
		response.setResponseEntity(message);
		return response;
	}

	// -------------------------PRIVATE------------------------

	private boolean isAuth(Authentication auth) {
		boolean isAuth = false;
		if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
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
