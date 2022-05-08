package com.bean;

import lombok.Data;

@Data
public class Cart {
    /**
     *
     */
    private String cartid;

    /**
     *
     */
    private Integer userid;

    /**
     *
     */
    private Integer goodsid;

    /**
     *
     */
    private Double price;

    /**
     *
     */
    private Integer cnt;

    /**
     *
     */
    private Byte state;
}

