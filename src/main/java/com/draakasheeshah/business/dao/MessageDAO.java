package com.draakasheeshah.business.dao;

import java.util.List;

import com.draakasheeshah.business.bo.MessageEntity;
import com.draakasheeshah.business.util.SearchInput;

public interface MessageDAO {

	MessageEntity save(MessageEntity message);

	MessageEntity update(MessageEntity message);

	MessageEntity saveOrUpdate(MessageEntity message);

	MessageEntity get(long messageId);

	List<MessageEntity> loadAll();

	void delete(MessageEntity message);

	void deletePermanently(MessageEntity message);

	List<MessageEntity> loadAllByEmailId(String emailId);

	List<MessageEntity> loadAll(SearchInput searchInput);

	Long getTotalRowCount(SearchInput searchInput);

}
