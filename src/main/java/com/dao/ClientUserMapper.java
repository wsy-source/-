package com.dao;

import com.bean.Clientuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClientUserMapper {

    Clientuser queryUserByUsernameAndPassword(Clientuser clientuser);

    Integer insertClientUser(Clientuser clientuser);

    @Select("select * from db_shop.clientuser where tel = #{tel} ")
    Clientuser queryUserByTel(@Param("tel") String tel);

    Clientuser queryUserByConditional(Clientuser clientuser);

    @Select("select * from db_shop.clientuser where userid = #{id} ")
    Clientuser queryUserById(Integer id);
}
