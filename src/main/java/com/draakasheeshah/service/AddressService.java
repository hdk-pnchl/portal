package com.draakasheeshah.service;

import java.util.List;

import com.draakasheeshah.bo.AddressEntity;

public interface AddressService {
    AddressEntity saveAddress(AddressEntity address);

    void saveOrUpdateAddress(AddressEntity address);

    AddressEntity getAddress(long addressId);

    List<AddressEntity> loadAllAddress();

    void deleteAddress(AddressEntity address);

    void deleteAddressPermanently(AddressEntity address);
}
