package com.jita.erhuo.service;

import com.jita.erhuo.entity.dict.DictCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by guitar on 15/1/23.
 */
public interface DictService {
    public List<DictCategory> getAllRootCategories();
    public List<DictCategory> getCategoriesByParentId(Long parentId);
    public Map<String,List<DictCategory>> getAllChildrenMappedByRoot();
}
