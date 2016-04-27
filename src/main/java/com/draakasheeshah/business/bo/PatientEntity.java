package com.draakasheeshah.business.bo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class PatientEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6375406330820935381L;
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patient", fetch = FetchType.EAGER)
	private AddressEntity address;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
	private ObservationEntity observation;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
	private FamilyEntity family;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
	private InterrogateEntity interrogate;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
	private BasicDetailEntity basicDetail;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public ObservationEntity getObservation() {
		return observation;
	}

	public void setObservation(ObservationEntity observation) {
		this.observation = observation;
	}

	public FamilyEntity getFamily() {
		return family;
	}

	public void setFamily(FamilyEntity family) {
		this.family = family;
	}

	public InterrogateEntity getInterrogate() {
		return interrogate;
	}

	public void setInterrogate(InterrogateEntity interrogate) {
		this.interrogate = interrogate;
	}

	public BasicDetailEntity getBasicDetail() {
		return basicDetail;
	}

	public void setBasicDetail(BasicDetailEntity basicDetail) {
		this.basicDetail = basicDetail;
	}
}