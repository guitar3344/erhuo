package com.jita.erhuo.mapper;

import com.jita.erhuo.entity.dict.DictCategory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by guitar on 15/1/23.
 */
@Component
public interface DictCategoryMapper {
    public List<DictCategory> getAllRootCategories();
    public List<DictCategory> getCategoriesByParentId(Long id);
    public List<DictCategory> getAllChildren();
}
