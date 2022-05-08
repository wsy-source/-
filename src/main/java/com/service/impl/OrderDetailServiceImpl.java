package com.service.impl;

import com.bean.OrderDetail;
import com.dao.OrderDetailDao;
import com.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;
    @Override
    public Integer insertOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.insertOrderDetail(orderDetail);
    }
}
