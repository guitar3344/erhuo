package com.jita.erhuo.service;

import com.github.pagehelper.PageInfo;
import com.jita.erhuo.entity.Goods;

import java.util.List;

/**
 * Created by guitar on 15/1/25.
 */
public interface GoodsService {
    public PageInfo<Goods> getGoodsOfCategoryByPage(String categoryCode, int pageNum, String order,String dir);
}
