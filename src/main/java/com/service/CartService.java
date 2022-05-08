package com.service;

import com.bean.state.CartState;
import com.bean.vo.GoodsVo;

import java.util.List;

public interface CartService {

    Integer addCart( Integer goodsid, Integer userid,Integer count);

    Integer updateCartCount(Integer goodsid, Integer userid,Integer count);

    Integer updateCartState( List<Integer> goodsid, Integer userid, CartState cartState);

    Integer queryCartGoodsCount( Integer goodsid , Integer userid);

    List<GoodsVo> queryCartGoodsByUserId(Integer userId);

    CartState queryCartStateByUseridAndGoodsId( Integer userid ,  Integer goodsid);

}
