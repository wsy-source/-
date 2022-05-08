package com.service.impl;

import com.bean.Goodskind;
import com.dao.GoodsKindDao;
import com.service.GoodsKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsKindServiceImpl implements GoodsKindService {
    @Autowired
    private GoodsKindDao goodsKindDao;

    @Override
    public List<Goodskind> queryAllGoodsKind() {
        return goodsKindDao.queryAllGoodsKind();
    }
}
