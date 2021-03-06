package com.draakasheeshah.business.service;

import java.util.List;

import com.draakasheeshah.business.bo.MessageEntity;
import com.draakasheeshah.business.util.SearchInput;

public interface MessageService {

	MessageEntity save(MessageEntity message);

	MessageEntity update(MessageEntity message);

	MessageEntity saveOrUpdate(MessageEntity message);

	MessageEntity get(long messageId);

	List<MessageEntity> loadAll();

	void delete(MessageEntity message);

	void deletePermanently(MessageEntity message);

	List<MessageEntity> loadAllByEmailId(String emailId);

	List<MessageEntity> getAll(SearchInput searchInput);

	Long getTotalRowCount(SearchInput searchInput);
}
