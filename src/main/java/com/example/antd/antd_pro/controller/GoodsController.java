package com.example.antd.antd_pro.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.constant.ErrorEnum;
import com.example.antd.antd_pro.entity.GoodsEntity;
import com.example.antd.antd_pro.service.GoodsService;
import com.example.antd.antd_pro.utils.R;
import com.example.antd.antd_pro.vo.GoodsAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("count")
    public R goodsCount() {
        long count = goodsService.count();
        return R.ok().put("count", count);
    }

    @PostMapping("/add")
    public R addGoods(@RequestBody GoodsAddVo goodsAddVo, HttpServletRequest request) {
        try {
            String token = request.getHeader("Authorization");
            goodsService.addGoods(goodsAddVo, token);
            return R.ok();
        } catch (Exception e) {
            return R.error(ErrorEnum.FAILED_TO_ADD_USER.getCode(), ErrorEnum.FAILED_TO_ADD_USER.getMessage());
        }
    }

    @PutMapping("/{goodsId}/update")
    public R updateGoods(@PathVariable("goodsId") String goodsId, @RequestBody GoodsAddVo goodsAddVo) {
        try {
            goodsService.updateGoods(goodsId, goodsAddVo);
            return R.ok();
        } catch (Exception e) {
            return R.error(ErrorEnum.FAILED_TO_UPDATE_USER.getCode(), ErrorEnum.FAILED_TO_UPDATE_USER.getMessage());
        }
    }

    @GetMapping("/{goodsId}")
    public R getGoodsInfo(@PathVariable("goodsId") String goodsId) {
        GoodsAddVo goods = goodsService.getGoodsInfo(goodsId);
        return R.ok().put("goodsInfo", goods);
    }
}
