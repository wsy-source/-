package com.dao;

import com.bean.Order;
import com.bean.vo.OrderVo;
import com.bean.vo.UpdateOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    Integer insertOrder(Order order);

    List<OrderVo> queryAdminOrders();

    void updateOrderInfo(UpdateOrderVo orderVo);

    OrderVo queryAdminOrderById(Integer id);
}
