package com.example.antd.antd_pro.controller;


import com.example.antd.antd_pro.entity.CategoryEntity;
import com.example.antd.antd_pro.service.CategoryService;
import com.example.antd.antd_pro.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品三级分类
 * @TableName category
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public R getCategoryList() {
        List<CategoryEntity> categoryList= categoryService.listWithTree();
        return R.ok().put("categoryList", categoryList);
    }

}