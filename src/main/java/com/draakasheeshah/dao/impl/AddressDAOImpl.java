package com.draakasheeshah.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.draakasheeshah.bo.AddressEntity;
import com.draakasheeshah.dao.AddressDAO;

@Repository
public class AddressDAOImpl
    implements AddressDAO
{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public AddressEntity saveAddress(AddressEntity address) {
        return (AddressEntity)hibernateTemplate.save(address);
    }

    @Override
    public void saveOrUpdateAddress(AddressEntity address) {
        hibernateTemplate.save(address);
    }

    @Override
    public AddressEntity getAddress(long addressId) {
        return hibernateTemplate.get(AddressEntity.class, addressId);
    }

    @Override
    public List<AddressEntity> loadAllAddress() {
        return hibernateTemplate.loadAll(AddressEntity.class);
    }

    @Override
    public void deleteAddress(AddressEntity address) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAddressPermanently(AddressEntity address) {
        hibernateTemplate.delete(address);
    }
}