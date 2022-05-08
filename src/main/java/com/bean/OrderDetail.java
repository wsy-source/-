package com.bean;

import lombok.Data;

@Data
public class OrderDetail {
    /**
     *
     */
    private Integer did;

    /**
     *
     */
    private Integer ordid;


    private Integer goodsid;

    /**
     *
     */
    private Double price;

    /**
     *
     */
    private Integer cnt;
}

