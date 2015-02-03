package com.jita.erhuo.mapper;

import com.jita.erhuo.entity.Goods;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by guitar on 15/1/25.
 */
@Component
public interface GoodsMapper {
    public List<Goods> getGoodsByCategory(String categoryCode,String order,String dir);

    public int save(Goods goods);
}
