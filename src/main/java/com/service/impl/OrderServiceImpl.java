package com.service.impl;

import com.bean.Order;
import com.bean.vo.OrderVo;
import com.bean.vo.UpdateOrderVo;
import com.dao.OrderDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Integer insertOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public PageInfo<OrderVo> queryAdminOrders(Integer pageNum, Integer pageSize) {
        Page<OrderVo> page = PageHelper.startPage(pageNum, pageSize);
        List<OrderVo> orderVos = orderDao.queryAdminOrders();
        PageInfo<OrderVo> orders = new PageInfo<>(page);
        return orders;
    }

    @Override
    public OrderVo queryAdminOrderById(Integer id) {
        OrderVo orderInfo = orderDao.queryAdminOrderById(id);
        return orderInfo;
    }

    @Override
    public void updateOrderInfo(UpdateOrderVo orderVo) {
        orderDao.updateOrderInfo(orderVo);
    }
}
