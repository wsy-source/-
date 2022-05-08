package com.service.impl;

import com.bean.Goods;
import com.bean.dto.GoodsConditional;
import com.bean.vo.GoodsVo;
import com.dao.GoodsDao;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> queryAllGoods() {
        return goodsDao.queryAllGoods();
    }

    @Override
    public Goods queryGoodsById(Integer goodsid) {
        return goodsDao.queryGoodsById(goodsid);
    }

    @Override
    public List<Goods> queryAllGoodsByGoodsConditional(GoodsConditional goodsConditional) {
        return goodsDao.queryAllGoodsByGoodsConditional(goodsConditional);
    }

    @Override
    public List<GoodsVo> queryAllGoodsById(Integer userid) {
        return goodsDao.queryAllGoodsById(userid);
    }

    @Override
    public Integer insertGoods(Goods goods) {
        return goodsDao.insertGoods(goods);
    }


}
