package com.bean.vo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class RegisterUser {


    private Integer userid;

    private String username;

    private String tel;

    private String password;

    private Date joinDate;

    private String address;

    private Byte defaultAddress;

    private String photo;

}
