package com.example.antd.antd_pro.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.constant.ErrorEnum;
import com.example.antd.antd_pro.entity.SpikePromotionEntity;
import com.example.antd.antd_pro.entity.SpikePromotionSessionEntity;
import com.example.antd.antd_pro.entity.UserEntity;
import com.example.antd.antd_pro.service.SpikePromotionService;
import com.example.antd.antd_pro.service.SpikePromotionSessionService;
import com.example.antd.antd_pro.utils.R;
import com.example.antd.antd_pro.vo.UserAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/spike/promotion")
public class SpikePromotionController {
    @Autowired
    private SpikePromotionService spikePromotionService;

    @GetMapping("list")
    public R list(@RequestParam Map<String, Object> params) {
        Page<SpikePromotionEntity> spikePromotionPage = spikePromotionService.getSpikePromotionList(params);
        return R.ok().put("spikePromotionPage", spikePromotionPage);
    }

    @PostMapping("/add")
    public R addSpikePromotion(@RequestBody SpikePromotionEntity spikePromotionEntity) {
        try {
            spikePromotionEntity.setCreateTime(DateUtil.date());
            spikePromotionService.save(spikePromotionEntity);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @PutMapping("/upordown/{id}")
    public R upOrDown(@PathVariable("id") Long id) {
        try {
            spikePromotionService.upOrDown(id);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }
}
