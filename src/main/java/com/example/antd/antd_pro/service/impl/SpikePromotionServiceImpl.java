package com.example.antd.antd_pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.antd.antd_pro.entity.SpikePromotionEntity;
import com.example.antd.antd_pro.entity.UserEntity;
import com.example.antd.antd_pro.service.SpikePromotionService;
import com.example.antd.antd_pro.mapper.SpikePromotionMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author David
 * @description 针对表【spike_promotion(限时购表)】的数据库操作Service实现
 * @createDate 2023-05-07 17:10:01
 */
@Service
public class SpikePromotionServiceImpl extends ServiceImpl<SpikePromotionMapper, SpikePromotionEntity>
        implements SpikePromotionService {

    @Override
    public Page<SpikePromotionEntity> getSpikePromotionList(Map<String, Object> params) {
        LambdaQueryWrapper<SpikePromotionEntity> queryWrapper = new LambdaQueryWrapper<>();
        if (params.get("title") != null) {
            String title = params.get("title").toString();
            queryWrapper.like(SpikePromotionEntity::getTitle, title);
        }
        long current = Long.parseLong(params.get("current").toString());
        long pageSize = Long.parseLong(params.get("pageSize").toString());
        Page<SpikePromotionEntity> page = this.page(new Page<>(current, pageSize), queryWrapper);
        page.setTotal(page.getRecords().size());
        return page;
    }

    @Override
    public void upOrDown(Long id) {
        SpikePromotionEntity spikePromotion = this.getById(id);
        if (spikePromotion.getStatus() == 0) {
            spikePromotion.setStatus(1);
        } else {
            spikePromotion.setStatus(0);
        }
        this.updateById(spikePromotion);
    }
}




