package com.jita.erhuo.service.impl;

import com.jita.erhuo.entity.GoodsPicture;
import com.jita.erhuo.form.PictureItem;
import com.jita.erhuo.mapper.GoodsPictureMapper;
import com.jita.erhuo.service.GoodsPictureService;
import com.jita.erhuo.util.MongoManager;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * Created by guitar on 15/2/1.
 */
@Service
public class GoodsPictureServiceImpl implements GoodsPictureService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsPictureMapper goodsPictureMapper;

    @Override
    public Long saveGoodsPic(PictureItem item) {
        DB db = MongoManager.getDB("goods_pic");
        GridFS gridFS = new GridFS(db);
        GridFSInputFile mongoFile;

        mongoFile = gridFS.createFile(item.getData());
        mongoFile.setId(item.getId());
        mongoFile.setFilename(item.getOriginalName());
        mongoFile.setContentType(item.getType());
        mongoFile.save();

        GoodsPicture goodsPicture = new GoodsPicture();
        goodsPicture.setOriginalPic(item.getId());
        //TODO setSeq
        goodsPictureMapper.save(goodsPicture);

        return goodsPicture.getId();
    }

    @Override
    public PictureItem getGoodsPic(String key, String size) {
        DB db = MongoManager.getDB("goods_pic");
        GridFS gridFS = new GridFS(db);

        DBObject query = new BasicDBObject("_id",key);
        GridFSDBFile gridFSDBFile = gridFS.findOne(query);

        PictureItem pictureItem = new PictureItem();
        pictureItem.setId(gridFSDBFile.getId().toString());
        pictureItem.setOriginalName(gridFSDBFile.getFilename());
        pictureItem.setType(gridFSDBFile.getContentType());
        pictureItem.setData(gridFSDBFile.getInputStream());
        return pictureItem;
    }
}
