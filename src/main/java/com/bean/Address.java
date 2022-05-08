package com.bean;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Address {
    /**
     *
     */
    private Integer aid;

    /**
     *
     */
    private Integer userid;

    /**
     *
     */
    private String address;

    /**
     *
     */
    private Byte defaultAddress;
}

