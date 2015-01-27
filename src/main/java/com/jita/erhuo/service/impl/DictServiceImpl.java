package com.jita.erhuo.service.impl;

import com.jita.erhuo.entity.dict.DictCategory;
import com.jita.erhuo.mapper.DictCategoryMapper;
import com.jita.erhuo.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
