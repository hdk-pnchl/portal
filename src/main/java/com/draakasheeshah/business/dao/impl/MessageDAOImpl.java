package com.draakasheeshah.business.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.draakasheeshah.business.bo.MessageEntity;
import com.draakasheeshah.business.dao.AbstractDAO;
import com.draakasheeshah.business.dao.MessageDAO;

@Repository
@Transactional
public class MessageDAOImpl extends AbstractDAO implements MessageDAO {

	@Override
	public MessageEntity save(MessageEntity message) {
		this.getSession().save(message);
		return message;
	}

	@Override
	public MessageEntity update(MessageEntity message) {
		this.getSession().update(message);
		return message;
	}

	@Override
	public MessageEntity saveOrUpdate(MessageEntity message) {
		this.getSession().saveOrUpdate(message);
		return message;
	}

	@Override
	public MessageEntity get(long messageId) {
		MessageEntity message = null;
		Object patientObject = this.getSession().get(MessageEntity.class, messageId);
		if (patientObject != null) {
			message = (MessageEntity) patientObject;
		}
		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageEntity> loadAll() {
		Criteria criteria = getSession().createCriteria(MessageEntity.class);
		return (List<MessageEntity>) criteria.list();
	}

	@Override
	public List<MessageEntity> loadAllByEmailId(String emailId) {
		Criteria criteria = getSession().createCriteria(MessageEntity.class);
		if (emailId != null) {
			criteria.add(Restrictions.eq("emailId", emailId));
		}
		@SuppressWarnings("unchecked")
		List<MessageEntity> messageList = criteria.list();
		return messageList;
	}

	@Override
	public void delete(MessageEntity message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePermanently(MessageEntity message) {
		this.getSession().delete(message);
	}
}