package com.example.antd.antd_pro.controller;


import com.example.antd.antd_pro.entity.CategoryEntity;
import com.example.antd.antd_pro.service.CategoryService;
import com.example.antd.antd_pro.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品三级分类
 *
 * @TableName category
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("list")
    public R getCategoryList() {
        List<CategoryEntity> categoryList = categoryService.listWithTree();
        return R.ok().put("categoryList", categoryList);
    }

    @PostMapping("add")
    public R addCategory(@RequestBody CategoryEntity categoryEntity) {
        try {
            categoryService.addCategory(categoryEntity);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }

    @DeleteMapping("delete/{id}")
    public R deleteCategory(@PathVariable("id") Long id) {
        try {
            categoryService.removeById(id);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }
}