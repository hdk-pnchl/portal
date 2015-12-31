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

import com.draakasheeshah.bo.ObservationEntity;
import com.draakasheeshah.service.ObservationService;

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
	public @ResponseBody ObservationEntity save(@RequestBody ObservationEntity address,
			@RequestParam("patientId") long patientId) {
		System.out.println("/Observation" + " : " + "/save");
		address = observationService.save(address, patientId);
		return address;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody ObservationEntity get(@RequestParam("observationId") long observationId) {
		System.out.println("/Observation" + " : " + "/get" + "/" + observationId);

		ObservationEntity observation = observationService.get(observationId);
		return observation;
	}

}
