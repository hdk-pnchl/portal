package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.FamilyEntity;
import com.draakasheeshah.dao.FamilyDAO;
import com.draakasheeshah.service.FamilyService;

@Service
public class AddressServiceImpl
    implements FamilyService
{
    @Autowired
    FamilyDAO familyDAO;

    @Override
    public FamilyEntity saveFamily(FamilyEntity family) {
        return familyDAO.saveFamily(family);
    }

    @Override
    public void saveOrUpdateFamily(FamilyEntity family) {
        familyDAO.saveOrUpdateFamily(family);
    }

    @Override
    public FamilyEntity getFamily(long familyId) {
        return familyDAO.getFamily(familyId);
    }

    @Override
    public List<FamilyEntity> loadAllFamily() {
        return familyDAO.loadAllFamily();
    }

    @Override
    public void deleteFamily(FamilyEntity family) {
        familyDAO.deleteFamily(family);
    }

    @Override
    public void deleteFamilyPermanently(FamilyEntity family) {
        familyDAO.deleteFamilyPermanently(family);
    }
}