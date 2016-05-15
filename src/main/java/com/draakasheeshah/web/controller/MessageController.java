package com.draakasheeshah.web.controller;

import java.io.IOException;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.draakasheeshah.business.bo.BasicDetailEntity;
import com.draakasheeshah.business.bo.MessageEntity;
import com.draakasheeshah.business.bo.ResponseEntity;
import com.draakasheeshah.business.service.MessageService;
import com.draakasheeshah.business.util.CommonUtil;
import com.draakasheeshah.business.util.ResponseParam;
import com.draakasheeshah.business.util.SearchInput;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/patients/message")
public class MessageController implements ResourceLoaderAware {
	private static final Logger logger = Logger.getLogger(MessageController.class);

	// instance

	@Autowired
	private MessageService messageService;

	private ResourceLoader resourceLoader;

	@Autowired
	private ObjectMapper objectMapper;

	// setter-getter

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	// web

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/Message" + " : " + "/test");
		try {
			response.getWriter().write("MessageController Yes, It works");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity save(@RequestBody MessageEntity message) {
		System.out.println("/Message" + " : " + "/save");
		message = messageService.save(message);
		ResponseEntity response = new ResponseEntity();
		response.setResponseEntity(message);
		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity update(@RequestBody MessageEntity message) {
		System.out.println("/Message" + " : " + "/update");
		message = messageService.update(message);
		ResponseEntity response = new ResponseEntity();
		response.setResponseEntity(message);
		return response;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity get(@RequestParam("messageId") long messageId) {
		System.out.println("/Message" + " : " + "/get");
		MessageEntity message = messageService.get(messageId);
		ResponseEntity response = new ResponseEntity();
		response.setResponseEntity(message);
		return response;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody List<MessageEntity> getAll() {
		logger.info("Getting all ");
		List<MessageEntity> messageList = null;
		if (CommonUtil.isAdmin()) {
			messageList = messageService.loadAll();
		} else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			messageList = messageService.loadAllByEmailId(auth.getName());
		}
		return messageList;
	}

	@RequestMapping(value = "/getAllBySeach", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity getAllBySeach(@RequestBody SearchInput searchInput) {
		System.out.println("/patient" + " : " + "/getAllBySeach");

		if (!CommonUtil.isAdmin()) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			searchInput.getSearchData().put(ResponseParam.EMAIL_ID.getDesc(), auth.getName());
		}

		List<MessageEntity> messageList = messageService.getAll(searchInput);
		long rowCount = messageService.getTotalRowCount(searchInput);

		Map<String, String> respMap = new HashMap<String, String>();
		respMap.put(ResponseParam.ROW_COUNT.getDesc(), String.valueOf(rowCount));
		respMap.put(ResponseParam.CURRENT_PAGE_NO.getDesc(), String.valueOf(searchInput.getPageNo()));
		respMap.put(ResponseParam.TOTAL_PAGE_COUNT.getDesc(),
				String.valueOf(CommonUtil.calculateNoOfPages(rowCount, searchInput.getRowsPerPage())));
		respMap.put(ResponseParam.ROWS_PER_PAGE.getDesc(), String.valueOf(searchInput.getRowsPerPage()));

		ResponseEntity response = new ResponseEntity();
		response.setResponseData(respMap);
		response.setResponseEntity(messageList);

		return response;
	}

	@RequestMapping(value = "/loadAllByEmailId", method = RequestMethod.GET)
	public @ResponseBody List<MessageEntity> loadAllByEmailId(@RequestParam("emailId") String emailId) {
		logger.info("Getting all ByEmailId");
		List<MessageEntity> messageList = messageService.loadAllByEmailId(emailId);
		return messageList;
	}

	/**
	 * http://localhost:8080/portal/ctrl/core/getBanner
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getMessageColumnData", method = RequestMethod.GET)
	public @ResponseBody List<Object> getMessageColumnData() throws IOException {
		Resource messageColumnJson = this.resourceLoader.getResource("classpath:data/json/messageColumnData.json");
		List<Object> patientColumnData = objectMapper.readValue(messageColumnJson.getFile(), List.class);
		logger.info("getPatientColumnData: " + patientColumnData);

		return patientColumnData;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getMessageFormData", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getMessageFormData() throws IOException {
		Resource messageFormData = this.resourceLoader.getResource("classpath:data/json/messageFormData.json");
		Map<String, Object> messageFormDataMap = objectMapper.readValue(messageFormData.getFile(), Map.class);
		logger.info("getMessageFormData: " + messageFormDataMap);

		return messageFormDataMap;
	}
}
