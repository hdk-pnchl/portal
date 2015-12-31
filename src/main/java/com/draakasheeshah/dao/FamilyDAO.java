package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.FamilyEntity;

public interface FamilyDAO {

    // -----Family

    FamilyEntity save(FamilyEntity family, long patientId);

    FamilyEntity saveOrUpdate(FamilyEntity family);

    FamilyEntity get(long familyId);

    List<FamilyEntity> loadAll();

    void delete(FamilyEntity family);

    void deletePermanently(FamilyEntity family);

}
