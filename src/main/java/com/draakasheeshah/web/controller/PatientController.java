package com.draakasheeshah.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/patient" + " : " + "/test");
		try {
			response.getWriter().write("Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody PatientEntity savePatient(@RequestBody PatientEntity patient) {
		System.out.println("/patient" + " : " + "/saveOrUpdate");
		patient = patientService.savePatient(patient);
		return patient;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody PatientEntity get(@RequestParam("patientid") long patientId) {

		System.out.println("/patient" + " : " + "/get" + "/" + patientId);

		PatientEntity patient = patientService.getFullPatient(patientId);
		return patient;
	}

	@RequestMapping(value = "/getFull", method = RequestMethod.GET)
	public @ResponseBody PatientEntity getFull(@RequestParam("patientid") long patientId) {

		System.out.println("/patient" + " : " + "/getFull" + "/" + patientId);

		PatientEntity patient = patientService.getFullPatient(patientId);
		return patient;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<PatientEntity> getAllPatients() {

		System.out.println("/patient" + " : " + "/getAll");

		List<PatientEntity> patientList = patientService.getAllPatients();
		return patientList;
	}
}
