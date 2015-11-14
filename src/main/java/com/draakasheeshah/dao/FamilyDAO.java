package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.FamilyEntity;

public interface FamilyDAO {

    // -----Family

    FamilyEntity saveFamily(FamilyEntity family);

    void saveOrUpdateFamily(FamilyEntity family);

    FamilyEntity getFamily(long familyId);

    List<FamilyEntity> loadAllFamily();

    void deleteFamily(FamilyEntity family);

    void deleteFamilyPermanently(FamilyEntity family);

}
