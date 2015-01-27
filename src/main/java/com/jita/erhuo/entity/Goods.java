package com.jita.erhuo.entity;

import com.jita.erhuo.common.enums.GoodsStatus;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by guitar on 15/1/25.
 */
@Entity
public class Goods implements Serializable {
    private Long id;
    private String title;
    private String description;
    private float originalPrice;
    private float price;
    private boolean canBargain;
    private String categoryCode;
    private String tradePlace;
    private String primaryPicture;
    private Long creatorId;
    private GoodsStatus status;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isCanBargain() {
        return canBargain;
    }

    public void setCanBargain(boolean canBargain) {
        this.canBargain = canBargain;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getTradePlace() {
        return tradePlace;
    }

    public void setTradePlace(String tradePlace) {
        this.tradePlace = tradePlace;
    }

    public String getPrimaryPicture() {
        return primaryPicture;
    }

    public void setPrimaryPicture(String primaryPicture) {
        this.primaryPicture = primaryPicture;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public GoodsStatus getStatus() {
        return status;
    }

    public void setStatus(GoodsStatus status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
