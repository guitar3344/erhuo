package com.jita.erhuo.mapper;

import com.jita.erhuo.entity.GoodsPicture;
import org.springframework.stereotype.Component;

/**
 * Created by guitar on 15/2/1.
 */
@Component
public interface GoodsPictureMapper {

    public GoodsPicture getPicturesByGoodsId(Long goodsId);
    public int save(GoodsPicture picture);
}
