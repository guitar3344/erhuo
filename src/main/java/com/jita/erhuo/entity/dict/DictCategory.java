package com.jita.erhuo.entity.dict;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by guitar on 15/1/23.
 */
@Entity
public class DictCategory implements Serializable{
    private Long id;
    private String code;
    private String name;
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
