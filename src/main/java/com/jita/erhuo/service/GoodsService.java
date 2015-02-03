package com.jita.erhuo.service;

import com.github.pagehelper.PageInfo;
import com.jita.erhuo.common.UserSession;
import com.jita.erhuo.entity.Goods;

import java.util.List;

/**
 * Created by guitar on 15/1/25.
 */
public interface GoodsService {
    public PageInfo<Goods> getGoodsOfCategoryByPage(String categoryCode, int pageNum, String order,String dir);

    /**
     * 发布商品
     * @param goods 商品信息
     * @param pictureIds 商品中的图片id列表
     * @param user 发布人信息
     * @return 商品id
     */
    public Long releaseGoods(Goods goods,List<Long> pictureIds,UserSession user);
}
