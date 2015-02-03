package com.jita.erhuo.controller;

import com.jita.erhuo.common.HttpResult;
import com.jita.erhuo.common.enums.GoodsStatus;
import com.jita.erhuo.entity.Goods;
import com.jita.erhuo.entity.dict.DictCategory;
import com.jita.erhuo.form.GoodsForm;
import com.jita.erhuo.service.DictService;
import com.jita.erhuo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by guitar on 15/1/28.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private DictService dictService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/release",method = RequestMethod.GET)
    public ModelAndView forwardReleasePage() {
        ModelAndView mav = new ModelAndView();
        List<DictCategory> rootCategories = dictService.getAllRootCategories();
        Map<String,List<DictCategory>> childrenCategoryMap = dictService.getAllChildrenMappedByRoot();
        mav.addObject("rootCategories",rootCategories);
        mav.addObject("childrenCategoryMap",childrenCategoryMap);
        mav.setViewName("goods/release");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value="/",method = RequestMethod.POST)
    public HttpResult<Long> releaseGoods(@RequestBody GoodsForm goodsForm){
        Goods goods = goodsForm.toGoods();
        goods.setStatus(GoodsStatus.VALID);
        goods.setCreateTime(new Date());
        goods.setCreatorId(1L);
        Long goodsId = goodsService.releaseGoods(goods,null,null);
        return HttpResult.OK(goodsId);
    }
}
