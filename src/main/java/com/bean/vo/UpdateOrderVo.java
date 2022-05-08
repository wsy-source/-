package com.bean.vo;

import com.bean.state.OrderState;
import lombok.Data;

@Data
public class UpdateOrderVo {

    private Integer ordid;

    private String address;

    private OrderState state;


}
