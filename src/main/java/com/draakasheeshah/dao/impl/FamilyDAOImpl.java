package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.draakasheeshah.bo.FamilyEntity;
import com.draakasheeshah.dao.FamilyDAO;

@Repository
public class FamilyDAOImpl
    implements FamilyDAO
{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public FamilyEntity saveFamily(FamilyEntity family) {
        return (FamilyEntity)hibernateTemplate.save(family);
    }

    @Override
    public void saveOrUpdateFamily(FamilyEntity family) {
        hibernateTemplate.saveOrUpdate(family);

    }

    @Override
    public FamilyEntity getFamily(long familyId) {
        return hibernateTemplate.get(FamilyEntity.class, familyId);
    }

    @Override
    public List<FamilyEntity> loadAllFamily() {
        return hibernateTemplate.loadAll(FamilyEntity.class);
    }

    @Override
    public void deleteFamily(FamilyEntity family) {
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteFamilyPermanently(FamilyEntity family) {
        hibernateTemplate.delete(family);
    }

}
