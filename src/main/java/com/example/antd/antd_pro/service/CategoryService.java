package com.example.antd.antd_pro.service;

import com.example.antd.antd_pro.entity.CategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author David
* @description 针对表【category(商品三级分类)】的数据库操作Service
* @createDate 2023-03-12 16:42:25
*/
public interface CategoryService extends IService<CategoryEntity> {

    List<CategoryEntity> listWithTree();

    List<Long> getCatIdList(Long categoryId);
}
