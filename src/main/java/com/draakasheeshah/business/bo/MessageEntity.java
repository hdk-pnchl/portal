package com.draakasheeshah.business.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MessageEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3439236310912778185L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String emailId;
	private String message;
	private String reply;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
