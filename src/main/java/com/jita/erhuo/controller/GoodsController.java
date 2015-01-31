package com.jita.erhuo.controller;

import com.jita.erhuo.entity.dict.DictCategory;
import com.jita.erhuo.service.DictService;
import com.jita.erhuo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView forwardPage() {
        ModelAndView mav = new ModelAndView();
        List<DictCategory> rootCategories = dictService.getAllRootCategories();
        Map<String,List<DictCategory>> childrenCategoryMap = dictService.getAllChildrenMappedByRoot();
        mav.addObject("rootCategories",rootCategories);
        mav.addObject("childrenCategoryMap",childrenCategoryMap);
        mav.setViewName("goods/release");
        return mav;
    }
}
