package com.jita.erhuo.form;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by guitar on 15/2/1.
 */
public class PictureItem {
    private String id;
    private String originalName;
    private String type;
    private InputStream data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InputStream getData() {
        return data;
    }

    public void setData(InputStream data) {
        this.data = data;
    }
}
