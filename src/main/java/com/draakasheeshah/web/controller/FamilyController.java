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

import com.draakasheeshah.business.bo.FamilyEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.service.FamilyService;

@Controller
@RequestMapping("/patients/family")
public class FamilyController {
	@Autowired
	private FamilyService familyService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/family" + " : " + "/test");
		try {
			response.getWriter().write("FamilyController Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody PatientEntity save(@RequestBody FamilyEntity family,
			@RequestParam("patientId") long patientId) {
		System.out.println("/Family" + " : " + "/save");
		PatientEntity patientEntity = familyService.saveWithPatient(family, patientId);
		return patientEntity;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody PatientEntity update(@RequestBody FamilyEntity family,
			@RequestParam("patientId") long patientId) {
		System.out.println("/Family" + " : " + "/update");
		PatientEntity patient = familyService.update(family, patientId);
		return patient;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody FamilyEntity get(@RequestParam("familyId") long familyId) {
		System.out.println("/Family" + " : " + "/get" + "/" + familyId);
		FamilyEntity family = familyService.get(familyId);
		return family;
	}
}