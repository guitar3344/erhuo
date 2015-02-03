package com.jita.erhuo.form;

import com.jita.erhuo.entity.Goods;

/**
 * Created by guitar on 15/2/3.
 */
public class GoodsForm {
    private Long id;
    private String title;
    private String description;
    private float originalPrice;
    private float price;
    private boolean canBargain;
    private String categoryCode;
    private String tradePlace;
    private String goodsPics;

    public Goods toGoods(){
        Goods goods = new Goods();
        goods.setTitle(this.title);
        goods.setDescription(this.description);
        goods.setCategoryCode(this.categoryCode);
        goods.setPrice(this.price);
        goods.setOriginalPrice(this.originalPrice);
        goods.setCanBargain(this.canBargain);
        goods.setTradePlace(this.tradePlace);

        goods.setPrimaryPicture(this.goodsPics.split(",")[0]);
        return goods;
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

    public String getGoodsPics() {
        return goodsPics;
    }

    public void setGoodsPics(String goodsPics) {
        this.goodsPics = goodsPics;
    }
}
