package com.service.impl;

import com.bean.Clientuser;
import com.bean.SysAdmin;
import com.dao.AdminDao;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public SysAdmin loginAdmin() {
        return adminDao.queryAdmin();
    }

    @Override
    public SysAdmin queryAdmin(Clientuser clientuser) {
        return adminDao.queryAdminByAdminnameAndPassword(clientuser);
    }
}
