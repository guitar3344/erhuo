package com.jita.erhuo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jita.erhuo.common.UserSession;
import com.jita.erhuo.entity.Goods;
import com.jita.erhuo.mapper.GoodsMapper;
import com.jita.erhuo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guitar on 15/1/25.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageInfo<Goods> getGoodsOfCategoryByPage(String categoryCode, int pageNum, String order, String dir) {
        PageHelper.startPage(pageNum, 10);
        List<Goods> list = goodsMapper.getGoodsByCategory(categoryCode,order,dir);
        PageInfo<Goods> page = new PageInfo<Goods>(list);
        return page;
    }

    @Override
    public Long releaseGoods(Goods goods, List<Long> pictureIds, UserSession user) {
        goodsMapper.save(goods);
        return goods.getId();
    }
}
