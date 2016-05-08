package com.draakasheeshah.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.MessageEntity;
import com.draakasheeshah.business.dao.MessageDAO;
import com.draakasheeshah.business.service.MessageService;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageDAO messageDAO;

	@Override
	public MessageEntity save(MessageEntity message) {
		return messageDAO.save(message);
	}

	@Override
	public MessageEntity update(MessageEntity message) {
		return messageDAO.update(message);
	}

	@Override
	public MessageEntity saveOrUpdate(MessageEntity message) {
		return messageDAO.saveOrUpdate(message);
	}

	@Override
	public MessageEntity get(long messageId) {
		return messageDAO.get(messageId);
	}

	@Override
	public List<MessageEntity> loadAll() {
		return messageDAO.loadAll();
	}

	@Override
	public void delete(MessageEntity message) {
		messageDAO.delete(message);
	}

	@Override
	public void deletePermanently(MessageEntity message) {
		messageDAO.deletePermanently(message);
	}

	@Override
	public List<MessageEntity> loadAllByEmailId(String emailId) {
		return messageDAO.loadAllByEmailId(emailId);
	}
}