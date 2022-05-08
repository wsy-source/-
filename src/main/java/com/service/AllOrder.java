package com.service;

import com.bean.Clientuser;
import com.bean.vo.GoodsVo;

public interface AllOrder {

    void insertOrderAndOrderDetail(Clientuser clientuser, GoodsVo goodsVo);
}
