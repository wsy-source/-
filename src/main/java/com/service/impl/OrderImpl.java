package com.service.impl;

import com.bean.Clientuser;
import com.bean.Order;
import com.bean.OrderDetail;
import com.bean.vo.GoodsVo;
import com.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderImpl implements AllOrder {

    @Autowired
    private UserService UserService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Transactional
    @Override
    public void insertOrderAndOrderDetail(Clientuser clientuser, GoodsVo goodsVo) {
        Order order = new Order();
        OrderDetail orderDetail = new OrderDetail();
        Clientuser user = UserService.queryUserByUsernameAndPassword(clientuser);
        BeanUtils.copyProperties(user, order);
        BeanUtils.copyProperties(goodsVo, order);
        orderService.insertOrder(order);
        Integer ordid = order.getOrdid();
        orderDetail.setOrdid(ordid);
        BeanUtils.copyProperties(goodsVo, orderDetail);
        orderDetailService.insertOrderDetail(orderDetail);
    }

}
