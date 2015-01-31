package com.jita.erhuo.service.impl;

import com.jita.erhuo.entity.dict.DictCategory;
import com.jita.erhuo.mapper.DictCategoryMapper;
import com.jita.erhuo.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guitar on 15/1/23.
 */
@Service
@Transactional
public class DictServiceImpl implements DictService{

    @Autowired
    private DictCategoryMapper dictCategoryMapper;

    @Override
    public List<DictCategory> getAllRootCategories() {
        return dictCategoryMapper.getAllRootCategories();
    }

    @Override
    public List<DictCategory> getCategoriesByParentId(Long parentId) {
        return dictCategoryMapper.getCategoriesByParentId(parentId);
    }

    @Override
    public Map<String, List<DictCategory>> getAllChildrenMappedByRoot() {
        List<DictCategory> children = dictCategoryMapper.getAllChildren();
        Map<String,List<DictCategory>> map = new HashMap<String, List<DictCategory>>();
        for(DictCategory category:children){
            if(!map.containsKey(category.getParentId().toString())){
                map.put(category.getParentId().toString(),new ArrayList<DictCategory>());
            }
            map.get(category.getParentId().toString()).add(category);
        }
        return map;
    }
}
