package com.draakasheeshah.business.bo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.draakasheeshah.business.enums.Sex;
import com.draakasheeshah.business.util.CommonUtil;

@Entity
@Table
public class BasicDetailEntity implements Serializable, UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2513263582847293133L;
	@Id
	@GeneratedValue
	private long patinetId;
	private String name;
	private String emailId;
	private long regNo;
	private String patientPassword;

	private int age;
	private Sex sex;
	private int marriageFlag;
	private String education;
	private String occupation;

	private boolean isAccountExpired;
	private boolean isAccountLocked;
	private boolean isAccountEnabled;
	private boolean isAccountCredentialsExpired;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PATIENT_ROLE", joinColumns = @JoinColumn(name = "patinetId") , inverseJoinColumns = @JoinColumn(name = "authorityId") )
	private Set<AuthorityEntity> roles = new HashSet<AuthorityEntity>();

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "patient")
	private PatientEntity patient;

	public BasicDetailEntity() {
		this.populateRegNo();
	}

	public long getPatinetId() {
		return patinetId;
	}

	public void setPatinetId(long patinetId) {
		this.patinetId = patinetId;
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

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public boolean isAccountExpired() {
		return isAccountExpired;
	}

	public void setAccountExpired(boolean isAccountExpired) {
		this.isAccountExpired = isAccountExpired;
	}

	public boolean isAccountLocked() {
		return isAccountLocked;
	}

	public void setAccountLocked(boolean isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}

	public boolean isAccountEnabled() {
		return isAccountEnabled;
	}

	public void setAccountEnabled(boolean isAccountEnabled) {
		this.isAccountEnabled = isAccountEnabled;
	}

	public boolean isAccountCredentialsExpired() {
		return isAccountCredentialsExpired;
	}

	public void setAccountCredentialsExpired(boolean isAccountCredentialsExpired) {
		this.isAccountCredentialsExpired = isAccountCredentialsExpired;
	}

	public Set<AuthorityEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<AuthorityEntity> roles) {
		this.roles = roles;
	}

	// -------------

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getRoles();
	}

	@Override
	public String getUsername() {
		return this.getEmailId();
	}

	@Override
	public String getPassword() {
		return this.getPatientPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return !this.isAccountExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return !this.isAccountLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isAccountCredentialsExpired();
	}

	@Override
	public boolean isEnabled() {
		return this.isAccountEnabled();
	}
}
