package com.dao;

import com.bean.Cart;
import com.bean.dto.CartStatesDto;
import com.bean.state.CartState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartDao {

    @Select("select * from db_shop.cart where userid = #{userId} and state = 0 ")
    List<Cart> queryAllCartItemByUserId(@Param("userId") Integer userId);

    @Select("select * from db_shop.cart where db_shop.cart.userid = #{userid} and db_shop.cart.goodsid = #{goodis} " +
            "and state = 0 ")
    Cart queryCartByUseridAndGoodsId(@Param("userid") Integer userid , @Param("goodis") Integer goodsid);

    Integer addCart(Cart cart);

    Integer updateCartCount(@Param("cart") Cart  cart, @Param("count") Integer count);

    Integer updateCartState(@Param("goodsid") List<Integer> goodsid,@Param("userid") Integer userid,
                            @Param("state")CartState cartState);

    @Select("select db_shop.cart.cnt where db_shop.cart.goodsid = #{goodsid} ")
    Integer queryCartGoodsCount(@Param("goodsid") Integer goodsid,@Param("userid")Integer userid);


    CartStatesDto queryCartStateByUseridAndGoodsId(@Param("userid") Integer userid , @Param("goodsid") Integer goodsid);

}
