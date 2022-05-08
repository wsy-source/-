package com.service;

import com.bean.Clientuser;
import com.bean.SysAdmin;

public interface AdminService {

    SysAdmin loginAdmin();

    SysAdmin queryAdmin(Clientuser clientuser);
}
