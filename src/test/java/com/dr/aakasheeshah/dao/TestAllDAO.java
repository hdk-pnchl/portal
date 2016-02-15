package com.dr.aakasheeshah.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.draakasheeshah.business.bo.AddressEntity;
import com.draakasheeshah.business.bo.ObservationEntity;
import com.draakasheeshah.business.bo.PatientEntity;

//@RunWith(MockitoJUnitRunner.class)
public class TestAllDAO {
	private ApplicationContext ctx;
	private HibernateTemplate HibernateTemplate;

	// @Before
	public void setup() {
		// ctx = new
		// ClassPathXmlApplicationContext("spring-datasource-test.xml");
		// HibernateTemplate = (HibernateTemplate)
		// ctx.getBean("hibernateTemplate");
	}

	// @Test
	public void emptyTest() {
		System.out.println("all good.");
	}

	// @Test
	public void testPatient() {
		PatientEntity patientEntity = new PatientEntity();
		System.out.println(patientEntity.getId());
		long patientId = (long) HibernateTemplate.save(patientEntity);

		AddressEntity addressEntity = new AddressEntity();
		long addressId = (long) HibernateTemplate.save(addressEntity);

		patientEntity.setAddress(addressEntity);

		HibernateTemplate.saveOrUpdate(patientEntity);

	}

	// @Test
	public void testNotPatient() {
		ObservationEntity observationEntity = new ObservationEntity();
		// long observationId = (long)
		// HibernateTemplate.save(observationEntity);

		PatientEntity patientEntity = HibernateTemplate.get(PatientEntity.class, 1l);
		patientEntity.setObservation(observationEntity);

		HibernateTemplate.saveOrUpdate(patientEntity);
	}

	// @Test
	public void testObservation() {

		ObservationEntity observationEntity = HibernateTemplate.get(ObservationEntity.class, 1l);
		observationEntity.setBodyLanguage("looking good");
		observationEntity.setEyeContact("looking good");

		HibernateTemplate.saveOrUpdate(observationEntity);

		System.out.println("hows it looking: " + observationEntity.getBodyLanguage());
	}
}
