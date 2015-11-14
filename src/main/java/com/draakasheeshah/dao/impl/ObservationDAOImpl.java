package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.draakasheeshah.bo.ObservationEntity;
import com.draakasheeshah.dao.ObservationDAO;

@Repository
public class ObservationDAOImpl
    implements ObservationDAO
{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public ObservationEntity saveObservation(ObservationEntity observation) {
        return (ObservationEntity)hibernateTemplate.save(observation);
    }

    @Override
    public void saveOrUpdateObservation(ObservationEntity observation) {
        hibernateTemplate.save(observation);
    }

    @Override
    public ObservationEntity getObservation(long observationId) {
        return hibernateTemplate.get(ObservationEntity.class, observationId);
    }

    @Override
    public List<ObservationEntity> loadAllObservation() {
        return hibernateTemplate.loadAll(ObservationEntity.class);
    }

    @Override
    public void deleteObservation(ObservationEntity observationEntity) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteObservationPermanently(ObservationEntity observationEntity) {
        hibernateTemplate.delete(observationEntity);
    }
}