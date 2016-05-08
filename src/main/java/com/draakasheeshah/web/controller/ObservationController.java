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

import com.draakasheeshah.business.bo.ObservationEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.bo.ResponseEntity;
import com.draakasheeshah.business.service.ObservationService;

@Controller
@RequestMapping("/patients/observation")
public class ObservationController {
	@Autowired
	private ObservationService observationService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/observation" + " : " + "/test");

		try {
			response.getWriter().write("ObservationController Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity save(@RequestBody ObservationEntity observation,
			@RequestParam("patientId") long patientId) {
		System.out.println("/Observation" + " : " + "/save");
		PatientEntity patientEntity = observationService.saveWithPatient(observation, patientId);
		ResponseEntity response = new ResponseEntity();
		response.setResponseEntity(patientEntity);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity update(@RequestBody ObservationEntity observation,
			@RequestParam("patientId") long patientId) {
		System.out.println("/Observation" + " : " + "/update");
		ResponseEntity response = new ResponseEntity();
		PatientEntity patient = observationService.update(observation, patientId);
		response.setResponseEntity(patient);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody ObservationEntity get(@RequestParam("observationId") long observationId) {
		System.out.println("/Observation" + " : " + "/get" + "/" + observationId);

		ObservationEntity observation = observationService.get(observationId);
		return observation;
	}

}
