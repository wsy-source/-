package com.service;

import com.bean.Clientuser;

public interface UserService {

    Clientuser login(Clientuser clientuser);

    Integer insertUser(Clientuser clientuser);

    String checkUserByTel(String tel);

    String queryUserByConditional(Clientuser clientuser);

    Clientuser queryUserById(Integer id);

    Clientuser queryUserByUsernameAndPassword(Clientuser clientuser);
}
