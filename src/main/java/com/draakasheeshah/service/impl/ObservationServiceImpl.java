package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.ObservationEntity;
import com.draakasheeshah.dao.ObservationDAO;
import com.draakasheeshah.service.ObservationService;

@Service
public class ObservationServiceImpl
    implements ObservationService
{
    @Autowired
    ObservationDAO observationDAO;

    @Override
    public ObservationEntity saveObservation(ObservationEntity observationEntity) {
        return observationDAO.saveObservation(observationEntity);
    }

    @Override
    public void saveOrUpdateObservation(ObservationEntity observationEntity) {
        observationDAO.saveOrUpdateObservation(observationEntity);
    }

    @Override
    public ObservationEntity getObservation(long observationId) {
        return observationDAO.getObservation(observationId);
    }

    @Override
    public List<ObservationEntity> loadAllObservation() {
        return observationDAO.loadAllObservation();
    }

    @Override
    public void deleteObservation(ObservationEntity observationEntity) {
        observationDAO.deleteObservation(observationEntity);
    }

    @Override
    public void deleteObservationPermanently(ObservationEntity observationEntity) {
        observationDAO.deleteObservationPermanently(observationEntity);
    }
}