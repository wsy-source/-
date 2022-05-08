package com.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    /**
     *
     */
    private Integer ordid;

    /**
     *
     */
    private Integer userid;

    /**
     *
     */
    private Date ordDate;

    /**
     *
     */
    private String admin;

    /**
     *
     */
    private String address;

    /**
     *
     */
    private Byte state;
}

