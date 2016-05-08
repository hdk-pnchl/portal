package com.draakasheeshah.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.draakasheeshah.business.bo.InterrogateEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.bo.ResponseEntity;
import com.draakasheeshah.business.service.InterrogateService;

@Controller
@RequestMapping("/patients/interrogate")
public class InterrogateController {
	@Autowired
	private InterrogateService interrogateService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/interrogate" + " : " + "/test");
		try {
			response.getWriter().write("InterrogateController Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity save(@RequestBody InterrogateEntity address,
			@RequestParam("patientId") long patientId) {
		System.out.println("/Interrogate" + " : " + "/save");
		PatientEntity patientEntity = interrogateService.saveWithPatient(address, patientId);
		ResponseEntity response = new ResponseEntity();
		response.setResponseEntity(patientEntity);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity update(@RequestBody InterrogateEntity interrogate,
			@RequestParam("patientId") long patientId) {
		System.out.println("/Interrogate" + " : " + "/update");
		ResponseEntity response = new ResponseEntity();
		PatientEntity patient = interrogateService.update(interrogate, patientId);
		response.setResponseEntity(patient);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody InterrogateEntity get(@RequestParam("interrogateId") long interrogateId) {

		System.out.println("/Interrogate" + " : " + "/get" + "/" + interrogateId);

		InterrogateEntity interrogate = interrogateService.get(interrogateId);
		return interrogate;
	}

}
