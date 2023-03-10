package com.example.antd.antd_pro.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.entity.GoodsEntity;
import com.example.antd.antd_pro.service.GoodsService;
import com.example.antd.antd_pro.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("list")
    public R getGoods(@RequestParam Map<String, Object> params) {
        Page<GoodsEntity> goodsPage = goodsService.getGoods(params);
        return R.ok().put("goodsPage", goodsPage);
    }

    @PutMapping("{goodId}/isOn")
    public R isOn(@PathVariable("goodId") String goodId) {
        goodsService.isOn(goodId);
        return R.ok();
    }

    @PutMapping("{goodId}/isRecommend")
    public R isRecommend(@PathVariable("goodId") String goodId) {
        goodsService.isRecommend(goodId);
        return R.ok();
    }
}
