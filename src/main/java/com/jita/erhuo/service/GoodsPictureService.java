package com.jita.erhuo.service;

import com.jita.erhuo.form.PictureItem;

import java.io.InputStream;

/**
 * Created by guitar on 15/2/1.
 */
public interface GoodsPictureService {

    public Long saveGoodsPic(PictureItem item);

    public PictureItem getGoodsPic(String key,String size);
}
