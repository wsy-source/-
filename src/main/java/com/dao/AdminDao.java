package com.dao;

import com.bean.Clientuser;
import com.bean.SysAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminDao {

    @Select("select * from db_shop.sysadmin limit 1")
    SysAdmin queryAdmin();

    @Select("select * from db_shop.sysadmin where adminname= #{username} and password = #{password} ")
    SysAdmin queryAdminByAdminnameAndPassword(Clientuser clientuser);
}
