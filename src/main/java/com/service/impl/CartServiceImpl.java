package com.service.impl;

import com.bean.Cart;
import com.bean.Clientuser;
import com.bean.Goods;
import com.bean.state.CartState;
import com.bean.vo.GoodsVo;
import com.dao.CartDao;
import com.dao.ClientUserMapper;
import com.service.CartService;
import com.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    public static final CartState    CART_STATE = CartState.full;
    @Autowired
    private             CartDao      cartDao;
    @Autowired
    private             GoodsService goodsService;

    @Autowired
    private ClientUserMapper clientUserMapper;

    @Override
    @Transactional
    public Integer addCart(Integer goodsid, Integer userid, Integer count) {
        if (cartDao.queryCartByUseridAndGoodsId(userid, goodsid) != null &&
                cartDao.queryCartStateByUseridAndGoodsId(userid, goodsid) != null) {
            return updateCartCount(goodsid, userid, count);
        } else {
            Cart cart = new Cart();
            cart.setCnt(count);
            Goods goods = goodsService.queryGoodsById(goodsid);
            Clientuser clientuser = clientUserMapper.queryUserById(userid);
            BeanUtils.copyProperties(goods, cart);
            BeanUtils.copyProperties(clientuser, cart);
            //改变购物车 状态
            return cartDao.addCart(cart);
        }
    }

    @Override
    public Integer updateCartCount(Integer goodsid, Integer userid, Integer count) {
        Cart cart = new Cart();
        Goods goods = goodsService.queryGoodsById(goodsid);
        Clientuser clientuser = clientUserMapper.queryUserById(userid);
        BeanUtils.copyProperties(goods, cart);
        BeanUtils.copyProperties(clientuser, cart);
        return cartDao.updateCartCount(cart, count);
    }

    @Override
    public Integer updateCartState(List<Integer> goodsid, Integer userid, CartState cartState) {
        return cartDao.updateCartState(goodsid, userid,cartState);
    }

    @Override
    public Integer queryCartGoodsCount(Integer goodsid, Integer userid) {
        return cartDao.queryCartGoodsCount(userid, goodsid);
    }

    @Override
    @Transactional
    public List<GoodsVo> queryCartGoodsByUserId(Integer userId) {
        List<Cart> carts = cartDao.queryAllCartItemByUserId(userId);
        List<GoodsVo> vos = goodsService.queryAllGoodsById(userId);
        return vos;
    }

    @Override
    public CartState queryCartStateByUseridAndGoodsId(Integer userid, Integer goodsid) {
        return cartDao.queryCartStateByUseridAndGoodsId(userid, goodsid).getCartState();
    }

}
