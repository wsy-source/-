package com.dao;

import com.bean.Goodskind;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsKindDao {

    @Select("select * from db_shop.goodskind")
    List<Goodskind> queryAllGoodsKind();
}
