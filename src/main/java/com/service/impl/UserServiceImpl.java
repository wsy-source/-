package com.service.impl;

import com.bean.Clientuser;
import com.dao.ClientUserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ClientUserMapper clientUserMapper;

    @Override
    public Clientuser login(Clientuser clientuser) {
       return clientUserMapper.queryUserByUsernameAndPassword(clientuser);
    }

    @Override
    public Integer insertUser(Clientuser clientuser) {
        return clientUserMapper.insertClientUser(clientuser);
    }

    @Override
    public String checkUserByTel(String tel) {
        Clientuser clientuser = clientUserMapper.queryUserByTel(tel);
        if (clientuser == null){
            return "success";
        }else {
            return "fail";
        }
    }

    @Override
    public String queryUserByConditional(Clientuser clientuser) {
        Clientuser clientuser1 = clientUserMapper.queryUserByConditional(clientuser);
        if (clientuser1 == null){
            return "success";
        }else {
            return "fail";
        }
    }

    @Override
    public Clientuser queryUserById(Integer id) {
        return clientUserMapper.queryUserById(id);
    }

    @Override
    public Clientuser queryUserByUsernameAndPassword(Clientuser clientuser) {
        return clientUserMapper.queryUserByUsernameAndPassword(clientuser);
    }
}
