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

import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.service.PatientService;

@Controller
@RequestMapping("/patients/patient")
public class PatientController {
	private static final Logger logger = Logger.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		logger.info("Is working fine");
		try {
			response.getWriter().write("Patient saied: Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody PatientEntity save(@RequestBody PatientEntity patient) {
		logger.info("Saving: " + patient);
		patient = patientService.update(patient);
		return patient;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody PatientEntity update(@RequestBody PatientEntity patient) {
		logger.info("Updating: " + patient);
		patient = patientService.update(patient);
		return patient;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody PatientEntity get(@RequestParam("patientid") long patientId) {
		logger.info("Getting: " + patientId);
		PatientEntity patient = patientService.getFull(patientId);
		return patient;
	}

	@RequestMapping(value = "/getFull", method = RequestMethod.GET)
	public @ResponseBody PatientEntity getFull(@RequestParam("patientid") long patientId) {
		logger.info("Getting full: " + patientId);
		PatientEntity patient = patientService.getFull(patientId);
		return patient;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<PatientEntity> getAll() {
		logger.info("Getting all ");
		List<PatientEntity> patientList = patientService.getAll();
		return patientList;
	}
}
