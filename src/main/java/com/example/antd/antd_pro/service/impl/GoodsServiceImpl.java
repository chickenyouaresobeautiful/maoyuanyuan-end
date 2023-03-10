package com.example.antd.antd_pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.antd.antd_pro.entity.GoodsEntity;
import com.example.antd.antd_pro.entity.UserEntity;
import com.example.antd.antd_pro.service.GoodsService;
import com.example.antd.antd_pro.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author admin
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2023-03-10 14:12:22
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, GoodsEntity>
    implements GoodsService{

    @Override
    public Page<GoodsEntity> getGoods(Map<String, Object> params) {
        QueryWrapper<GoodsEntity> queryWrapper = new QueryWrapper<>();
        if (params.get("title") != null) {
            String title = params.get("title").toString();
            queryWrapper.like("title", title);
        }
        if (params.get("isOn") != null) {
            String isOn = params.get("isOn").toString();
            queryWrapper.eq("is_on", isOn);
        }
        if (params.get("isRecommend") != null) {
            String isRecommend = params.get("isRecommend").toString();
            queryWrapper.eq("is_recommend", isRecommend);
        }
        long current = Long.parseLong(params.get("current").toString());
        long pageSize = Long.parseLong(params.get("pageSize").toString());
        Page<GoodsEntity> page = this.page(new Page<>(current, pageSize), queryWrapper);
        page.setTotal(page.getRecords().size());
        return page;
    }

    @Override
    public void isOn(String goodId) {
        GoodsEntity goods = this.getById(goodId);
        if (goods.getIsOn() == 0) {
            goods.setIsOn(1);
        } else {
            goods.setIsOn(0);
        }
        this.updateById(goods);
    }

    @Override
    public void isRecommend(String goodId) {
        GoodsEntity goods = this.getById(goodId);
        if (goods.getIsRecommend() == 0) {
            goods.setIsRecommend(1);
        } else {
            goods.setIsRecommend(0);
        }
        this.updateById(goods);
    }
}




