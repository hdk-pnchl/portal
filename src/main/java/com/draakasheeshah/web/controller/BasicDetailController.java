package com.draakasheeshah.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.bo.ResponseEntity;
import com.draakasheeshah.business.service.BasicDetailService;
import com.draakasheeshah.business.service.PatientService;
import com.draakasheeshah.business.util.ResponseParam;

@Controller
@RequestMapping("/patients/basicDetail")
public class BasicDetailController {
	
	//instance
	
	@Autowired
	private BasicDetailService basicDetailService;
	
	@Autowired
	private PatientService patientService;

	//test
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/basicDetail" + " : " + "/test");
		try {
			response.getWriter().write("BasicDetailController. Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//web
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity save(@RequestBody BasicDetailEntity basicDetail) {
		System.out.println("/basicDetail" + " : " + "/save");
		ResponseEntity response = new ResponseEntity();

		BasicDetailEntity basicDetailExisting = basicDetailService.get(basicDetail.getEmailId());
		if (basicDetailExisting == null) {
			PatientEntity patientEntity = basicDetailService.saveWithPatient(basicDetail);
			response.setResponseEntity(patientEntity);
		} else {
			Map<String, String> respMap = new HashMap<String, String>();
			respMap.put(ResponseParam.ERROR_MSG.getErrorMessage(), "Email ID already taken");
			response.setResponseData(respMap);
		}

		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity update(@RequestBody BasicDetailEntity basicDetail,
			@RequestParam("patientId") long patientId) {
		System.out.println("/basicDetail" + " : " + "/update");
		ResponseEntity response = new ResponseEntity();
		PatientEntity patient = basicDetailService.update(basicDetail, patientId);
		response.setResponseEntity(patient);
		return response;
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody BasicDetailEntity saveOrUpdate(@RequestBody BasicDetailEntity basicDetail,
			@RequestParam("patientId") long patientId) {
		System.out.println("/basicDetail" + " : " + "/saveOrUpdate");
		basicDetail = basicDetailService.saveOrUpdate(basicDetail);
		PatientEntity patientEntity = patientService.get(patientId);
		patientEntity.setBasicDetail(basicDetail);
		return basicDetail;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody BasicDetailEntity get(@RequestParam("basicDetailId") long basicDetailId) {

		System.out.println("/basicDetail" + " : " + "/get" + "/" + basicDetailId);

		BasicDetailEntity basicDetail = basicDetailService.get(basicDetailId);
		return basicDetail;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<BasicDetailEntity> getAll() {
		System.out.println("/patient" + " : " + "/getAll");
		List<BasicDetailEntity> basicDetailList = basicDetailService.getAll();
		return basicDetailList;
	}
}
