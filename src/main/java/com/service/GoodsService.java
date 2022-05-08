package com.service;

import com.bean.Goods;
import com.bean.dto.GoodsConditional;
import com.bean.vo.GoodsVo;

import java.util.List;

public interface GoodsService {

    List<Goods> queryAllGoods();

    Goods queryGoodsById(Integer goodsid);

    List<Goods> queryAllGoodsByGoodsConditional(GoodsConditional goodsConditional);

    List<GoodsVo> queryAllGoodsById(Integer userid);

    Integer insertGoods(Goods goods);
}
