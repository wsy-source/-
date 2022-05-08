package com.bean;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
@Repository
public class Clientuser {
    /**
     *
     */
    private Integer userid;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private Date joinDate;

    /**
     *
     */
    private String tel;

    /**
     *
     */
    private String pid;

    /**
     *
     */
    private String photo;
}

