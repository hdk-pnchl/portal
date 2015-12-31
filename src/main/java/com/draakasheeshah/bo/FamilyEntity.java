package com.draakasheeshah.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class FamilyEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5723448549536829182L;
	@Id
	@GeneratedValue
	private long id;
	private String relation;
	private String durationOfStay;
	private String ability;
	private String concern;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "patient")
	private PatientEntity patient;

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getDurationOfStay() {
		return durationOfStay;
	}

	public void setDurationOfStay(String durationOfStay) {
		this.durationOfStay = durationOfStay;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getConcern() {
		return concern;
	}

	public void setConcern(String concern) {
		this.concern = concern;
	}

	@JsonIgnore
	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
