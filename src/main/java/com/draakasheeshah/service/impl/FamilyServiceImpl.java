package com.draakasheeshah.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draakasheeshah.bo.AddressEntity;
import com.draakasheeshah.dao.AddressDAO;
import com.draakasheeshah.service.AddressService;

@Service
public class FamilyServiceImpl
    implements AddressService
{
    @Autowired
    AddressDAO addressDAO;

    @Override
    public AddressEntity saveAddress(AddressEntity address) {
        return addressDAO.saveAddress(address);
    }

    @Override
    public void saveOrUpdateAddress(AddressEntity address) {
        addressDAO.saveOrUpdateAddress(address);
    }

    @Override
    public AddressEntity getAddress(long addressId) {
        return addressDAO.getAddress(addressId);
    }

    @Override
    public List<AddressEntity> loadAllAddress() {
        return addressDAO.loadAllAddress();
    }

    @Override
    public void deleteAddress(AddressEntity address) {
        addressDAO.deleteAddress(address);
    }

    @Override
    public void deleteAddressPermanently(AddressEntity address) {
        addressDAO.deleteAddressPermanently(address);
    }
}