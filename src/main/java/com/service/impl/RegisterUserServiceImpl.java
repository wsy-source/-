package com.service.impl;

import com.bean.Address;
import com.bean.Clientuser;
import com.bean.vo.RegisterUser;
import com.service.AddressService;
import com.service.RegisterUserService;
import com.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService    userService;
    @Autowired
    private Address        address;
    @Autowired
    private Clientuser     clientuser;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertRegisterUser(RegisterUser registerUser) {
        BeanUtils.copyProperties(registerUser, address);
        BeanUtils.copyProperties(registerUser, clientuser);
        userService.insertUser(this.clientuser);
        Integer userid = clientuser.getUserid();
        address.setUserid(userid);
        addressService.insertAddress(this.address);
    }
}
