package com.example.antd.antd_pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.antd.antd_pro.entity.CategoryEntity;
import com.example.antd.antd_pro.service.CategoryService;
import com.example.antd.antd_pro.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
* @author David
* @description 针对表【category(商品三级分类)】的数据库操作Service实现
* @createDate 2023-03-12 16:42:25
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity>
    implements CategoryService{

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> entities = this.list();
        List<CategoryEntity> level1Menu = new ArrayList<>();
        for (CategoryEntity entity : entities) {
            if (entity.getParentCid() == 0) {
                level1Menu.add(entity);
            }
            entity.setChildren(getChildren(entity, entities));
        }
        level1Menu.sort(new Comparator<CategoryEntity>() {
            @Override
            public int compare(CategoryEntity o1, CategoryEntity o2) {
                return o1.getSort() - o2.getSort();
            }
        });
        return level1Menu;
    }

    @Override
    public List<Long> getCatIdList(Long categoryId) {
        List<Long> catIds = new ArrayList<>();
        List<Long> resultList = findParentPath(categoryId, catIds);
        Collections.reverse(resultList);
        return resultList;
    }

    private List<Long> findParentPath(Long catalogId, List<Long> catIds) {
        catIds.add(catalogId);
        CategoryEntity categoryEntity = baseMapper.selectById(catalogId);
        if (categoryEntity.getParentCid() != 0) {
            //递归查找，如果当前菜单的父id不等于0则继续向上查找
            findParentPath(categoryEntity.getParentCid(), catIds);
        }
        return catIds;
    }

    private List<CategoryEntity> getChildren(CategoryEntity menu, List<CategoryEntity> categoryEntities) {
        List<CategoryEntity> result = new ArrayList<>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            if (categoryEntity.getParentCid().equals(menu.getCatId())) {
                result.add(categoryEntity);
            }
        }
        return result;
    }
}




