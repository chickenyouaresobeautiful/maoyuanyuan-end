package com.example.antd.antd_pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.antd.antd_pro.entity.SpikePromotionEntity;
import com.example.antd.antd_pro.entity.SpikePromotionSessionEntity;
import com.example.antd.antd_pro.entity.UserEntity;
import com.example.antd.antd_pro.service.SpikePromotionSessionService;
import com.example.antd.antd_pro.mapper.SpikePromotionSessionMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author David
* @description 针对表【spike_promotion_session(限时购场次表)】的数据库操作Service实现
* @createDate 2023-05-07 20:05:49
*/
@Service
public class SpikePromotionSessionServiceImpl extends ServiceImpl<SpikePromotionSessionMapper, SpikePromotionSessionEntity>
    implements SpikePromotionSessionService{

    @Override
    public Page<SpikePromotionSessionEntity> timePeriodList(Map<String, Object> params) {
        long current = Long.parseLong(params.get("current").toString());
        long pageSize = Long.parseLong(params.get("pageSize").toString());
        Page<SpikePromotionSessionEntity> page = this.page(new Page<>(current, pageSize));
        page.setTotal(page.getRecords().size());
        return page;
    }

    @Override
    public void enableOrDisable(Long id) {
        SpikePromotionSessionEntity spikePromotionSession = this.getById(id);
        if (spikePromotionSession.getStatus() == 0) {
            spikePromotionSession.setStatus(1);
        } else {
            spikePromotionSession.setStatus(0);
        }
        this.updateById(spikePromotionSession);
    }

    @Override
    public void updateSpikeSession(Long id, SpikePromotionSessionEntity spikePromotionSessionEntity) {
        SpikePromotionSessionEntity byId = this.getById(id);
        BeanUtils.copyProperties(spikePromotionSessionEntity, byId);
        byId.setId(id);
        this.updateById(byId);
    }
}




