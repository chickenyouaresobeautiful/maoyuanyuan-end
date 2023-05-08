package com.example.antd.antd_pro.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.constant.ErrorEnum;
import com.example.antd.antd_pro.entity.SpikePromotionEntity;
import com.example.antd.antd_pro.entity.SpikePromotionSessionEntity;
import com.example.antd.antd_pro.service.SpikePromotionService;
import com.example.antd.antd_pro.service.SpikePromotionSessionService;
import com.example.antd.antd_pro.utils.R;
import com.example.antd.antd_pro.vo.UserAddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/spike/session")
public class SpikePromotionSessionController {

    @Autowired
    private SpikePromotionSessionService spikePromotionSessionService;

    @GetMapping("/list")
    public R timePeriodList(@RequestParam Map<String, Object> params) {
        try {
            Page<SpikePromotionSessionEntity> spikePromotionSessionPage = spikePromotionSessionService.timePeriodList(params);
            return R.ok().put("spikePromotionSessionPage", spikePromotionSessionPage);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @PutMapping("/enableordisable/{id}")
    public R enableOrDisable(@PathVariable("id") Long id) {
        try {
            spikePromotionSessionService.enableOrDisable(id);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @PostMapping("/add")
    public R addSpikeSession(@RequestBody SpikePromotionSessionEntity spikePromotionSessionEntity) {
        try {
            spikePromotionSessionEntity.setCreateTime(DateUtil.date());
            spikePromotionSessionService.save(spikePromotionSessionEntity);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @GetMapping("/get/{id}")
    public R getSpikeSession(@PathVariable("id") Long id) {
        try {
            SpikePromotionSessionEntity spikePromotionSession = spikePromotionSessionService.getById(id);
            return R.ok().put("spikePromotionSession", spikePromotionSession);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @PutMapping("/update/{id}")
    public R updateSpikeSession(@PathVariable("id") Long id, @RequestBody SpikePromotionSessionEntity spikePromotionSessionEntity) {
        try {
            spikePromotionSessionService.updateSpikeSession(id, spikePromotionSessionEntity);
            return R.ok();
        } catch (Exception e) {
            return R.error(ErrorEnum.FAILED_TO_UPDATE_USER.getCode(), ErrorEnum.FAILED_TO_UPDATE_USER.getMessage());
        }
    }
}
