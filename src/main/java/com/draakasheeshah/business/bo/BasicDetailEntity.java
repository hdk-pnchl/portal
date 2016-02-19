package com.draakasheeshah.business.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.deaakasheeshah.business.util.CommonUtil;
import com.draakasheeshah.business.enums.Sex;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class BasicDetailEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2513263582847293133L;
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String emailId;
	private long regNo;

	private int age;
	private Sex sex;
	private int marriageFlag;
	private String education;
	private String occupation;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "patient")
	private PatientEntity patient;

	public BasicDetailEntity() {
		this.populateRegNo();
	}

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

	public long getRegNo() {
		return regNo;
	}

	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// ---------------

	public int getMarriageFlag() {
		return marriageFlag;
	}

	public void setMarriageFlag(int marriageFlag) {
		this.marriageFlag = marriageFlag;
	}

	/**
	 * This should not be used from anywhere other then BasicDetailEntity
	 * constructor
	 */
	private void populateRegNo() {
		this.setRegNo(CommonUtil.nextRegNo());
	}

	public boolean isMarried() {
		boolean isMarried = false;
		if (this.getMarriageFlag() == 1) {
			isMarried = true;
		}
		return isMarried;
	}

	public void processInternalData() {
		// this.populateIsMarried();
		// System.out.println("isMarried: " + this.isMarried());
	}
}
