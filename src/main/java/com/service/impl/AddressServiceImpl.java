package com.service.impl;

import com.bean.Address;
import com.dao.AddressMapper;
import com.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Integer insertAddress(Address address) {
        return addressMapper.insertAddress(address);
    }
}
