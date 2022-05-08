package com.bean.vo;

import lombok.Data;

@Data
public class OrderVo {
    private Integer ordid;
    private String  username;
    private String  goodsname;
    private Integer cnt;
    private String  address;
    private String tel;
}
