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

import com.draakasheeshah.business.bo.AddressEntity;
import com.draakasheeshah.business.bo.PatientEntity;
import com.draakasheeshah.business.bo.ResponseEntity;
import com.draakasheeshah.business.service.AddressService;

@Controller
@RequestMapping("/patients/address")
public class AddressController {
	@Autowired
	private AddressService addressService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/address" + " : " + "/test");
		try {
			response.getWriter().write("AddressController Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity save(@RequestBody AddressEntity address,
			@RequestParam("patientId") long patientId) {
		System.out.println("/Address" + " : " + "/save");
		PatientEntity patientEntity = addressService.saveWithPatient(address, patientId);
		ResponseEntity response = new ResponseEntity();
		response.setResponseEntity(patientEntity);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity update(@RequestBody AddressEntity address,
			@RequestParam("patientId") long patientId) {
		System.out.println("/Address" + " : " + "/saveOrUpdate");
		ResponseEntity response = new ResponseEntity();
		PatientEntity patient = addressService.update(address, patientId);
		response.setResponseEntity(patient);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody AddressEntity get(@RequestParam("addressId") long addressId) {

		System.out.println("/Address" + " : " + "/get" + "/" + addressId);

		AddressEntity address = addressService.get(addressId);
		return address;
	}

}
