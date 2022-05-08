package com.service;

import com.bean.Order;
import com.bean.vo.OrderVo;
import com.bean.vo.UpdateOrderVo;
import com.github.pagehelper.PageInfo;

public interface OrderService {

    Integer insertOrder(Order order);

    PageInfo<OrderVo> queryAdminOrders(Integer pageNum ,Integer pageSize);

     OrderVo queryAdminOrderById(Integer id);

    void updateOrderInfo(UpdateOrderVo orderVo);
}
