package com.draakasheeshah.dao;

import java.util.List;

import com.draakasheeshah.bo.AddressEntity;

public interface AddressDAO {

    // -----Address

    AddressEntity saveAddress(AddressEntity address);

    void saveOrUpdateAddress(AddressEntity address);

    AddressEntity getAddress(long addressId);

    List<AddressEntity> loadAllAddress();

    void deleteAddress(AddressEntity address);

    void deleteAddressPermanently(AddressEntity address);
}
