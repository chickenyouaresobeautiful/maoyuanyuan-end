package com.example.antd.antd_pro.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.entity.SpikePromotionSessionEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author David
* @description 针对表【spike_promotion_session(限时购场次表)】的数据库操作Service
* @createDate 2023-05-07 20:05:49
*/
public interface SpikePromotionSessionService extends IService<SpikePromotionSessionEntity> {

    Page<SpikePromotionSessionEntity> timePeriodList(Map<String, Object> params);

    void enableOrDisable(Long id);

    void updateSpikeSession(Long id, SpikePromotionSessionEntity spikePromotionSessionEntity);
}
