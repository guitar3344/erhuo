package com.jita.erhuo.view;

import com.jita.erhuo.entity.Goods;
import com.jita.erhuo.exceptions.DateFormatException;
import com.jita.erhuo.util.DateUtil;

/**
 * Created by guitar on 15/1/26.
 */
public class GoodsCard {
    private Long id;
    private String title;
    private String description;
    private float originalPrice;
    private float price;
    private boolean canBargain;
    private String categoryCode;
    private String tradePlace;
    private String picUrl;
    private String releaseTime;
    private int likeNum;
    private int commentNum;

    public static GoodsCard switchGoodsToCard(Goods goods){
        GoodsCard card = new GoodsCard();
        card.setId(goods.getId());
        card.setTitle(goods.getTitle());
        card.setDescription(goods.getDescription());
        card.setOriginalPrice(goods.getOriginalPrice());
        card.setPrice(goods.getPrice());
        card.setCanBargain(goods.isCanBargain());
        card.setCategoryCode(goods.getCategoryCode());
        card.setTradePlace(goods.getTradePlace());
        String primaryPic = goods.getPrimaryPicture();
        card.setPicUrl("/image/"+primaryPic.substring(0,8)+"/"+primaryPic);
        try {
            card.setReleaseTime(DateUtil.getFormatIntervalBeforeNow(goods.getCreateTime())+"发布");
        } catch (DateFormatException e) {
            card.setReleaseTime("");
        }

        return card;
    }

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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
}
