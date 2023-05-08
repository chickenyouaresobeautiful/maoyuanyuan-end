package com.example.antd.antd_pro.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.entity.SpikePromotionEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author David
* @description 针对表【spike_promotion(限时购表)】的数据库操作Service
* @createDate 2023-05-07 17:10:01
*/
public interface SpikePromotionService extends IService<SpikePromotionEntity> {

    Page<SpikePromotionEntity> getSpikePromotionList(Map<String, Object> params);

    void upOrDown(Long id);
}
