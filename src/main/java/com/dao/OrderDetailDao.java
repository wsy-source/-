package com.dao;

import com.bean.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailDao {

    Integer insertOrderDetail(OrderDetail orderDetail);

//    OrderDetail
}
