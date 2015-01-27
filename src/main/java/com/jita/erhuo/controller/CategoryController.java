package com.jita.erhuo.controller;

import com.github.pagehelper.PageInfo;
import com.jita.erhuo.entity.Goods;
import com.jita.erhuo.entity.User;
import com.jita.erhuo.entity.dict.DictCategory;
import com.jita.erhuo.service.DictService;
import com.jita.erhuo.service.GoodsService;
import com.jita.erhuo.view.GoodsCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guitar on 15/1/23.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private DictService dictService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView forwardPage(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("activeId", id);
        List<DictCategory> rootCategories = dictService.getAllRootCategories();
        List<DictCategory> children = dictService.getCategoriesByParentId(id);

        PageInfo<Goods> goodsPage = goodsService.getGoodsOfCategoryByPage(id.toString(),1,"update_time","desc");
        List<GoodsCard> cards = new LinkedList<GoodsCard>();
        for(Goods goods: goodsPage.getList()){
            cards.add(GoodsCard.switchGoodsToCard(goods));
        }

        mav.addObject("rootCategories", rootCategories);
        mav.addObject("children", children);
        mav.addObject("cards",cards);
        mav.addObject("goods_total_size",goodsPage.getTotal());
        mav.addObject("pageNum",goodsPage.getPageNum());
        mav.setViewName("home");
        return mav;
    }

    @RequestMapping(value = "/{id}/{subId}",method = RequestMethod.GET)
    public ModelAndView forwardPage(@PathVariable Long id,@PathVariable Long subId) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("activeId", id);
        mav.addObject("activeSubId", subId);
        List<DictCategory> rootCategories = dictService.getAllRootCategories();
        List<DictCategory> children = dictService.getCategoriesByParentId(id);

        PageInfo<Goods> goodsPage = goodsService.getGoodsOfCategoryByPage(subId.toString(),1,"update_time","desc");
        List<GoodsCard> cards = new LinkedList<GoodsCard>();
        for(Goods goods: goodsPage.getList()){
            cards.add(GoodsCard.switchGoodsToCard(goods));
        }

        mav.addObject("rootCategories", rootCategories);
        mav.addObject("children", children);
        mav.addObject("cards",cards);
        mav.addObject("goods_total_size",goodsPage.getTotal());
        mav.addObject("pageNum",goodsPage.getPageNum());
        mav.setViewName("home");
        return mav;
    }
}
