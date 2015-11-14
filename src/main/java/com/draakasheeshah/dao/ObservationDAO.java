package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.ObservationEntity;

public interface ObservationDAO {

    // -----Observation

    ObservationEntity saveObservation(ObservationEntity observationEntity);

    void saveOrUpdateObservation(ObservationEntity observationEntity);

    ObservationEntity getObservation(long observationId);

    List<ObservationEntity> loadAllObservation();

    void deleteObservation(ObservationEntity observationEntity);

    void deleteObservationPermanently(ObservationEntity observationEntity);
}
