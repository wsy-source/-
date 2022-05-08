package com.dao;

import com.bean.Goods;
import com.bean.dto.GoodsConditional;
import com.bean.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("select * from db_shop.goods")
    List<Goods> queryAllGoods();

    @Select("select * from db_shop.goods where db_shop.goods.goodsid = #{goodsid} ")
    Goods queryGoodsById(@Param("goodsid") Integer goodsid);

    List<Goods> queryAllGoodsByGoodsConditional(GoodsConditional goodsConditional);

    List<GoodsVo> queryAllGoodsById(@Param("userid") Integer userid );

    Integer insertGoods(Goods goods);
}
