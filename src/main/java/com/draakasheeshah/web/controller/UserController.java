package com.draakasheeshah.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.draakasheeshah.bo.BasicResponse;
import com.draakasheeshah.bo.PatientEntity;
import com.draakasheeshah.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public void fetchUser(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("/user" + " : " + "/fetch");

        userService.fetcUserList();
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public @ResponseBody BasicResponse addPerson(@RequestBody PatientEntity patient) {
        return new BasicResponse(1, "OK");
    }
}
