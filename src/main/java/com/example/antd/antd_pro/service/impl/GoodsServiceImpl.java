package com.example.antd.antd_pro.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.antd.antd_pro.entity.GoodsEntity;
import com.example.antd.antd_pro.entity.UserEntity;
import com.example.antd.antd_pro.service.CategoryService;
import com.example.antd.antd_pro.service.GoodsService;
import com.example.antd.antd_pro.mapper.GoodsMapper;
import com.example.antd.antd_pro.service.UserService;
import com.example.antd.antd_pro.to.DecreaseStockTo;
import com.example.antd.antd_pro.vo.GoodsAddVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @description 针对表【goods】的数据库操作Service实现
 * @createDate 2023-03-10 14:12:22
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, GoodsEntity> implements GoodsService {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

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

    @Override
    public void addGoods(GoodsAddVo goodsAddVo, String token) {
        GoodsEntity goodsEntity = new GoodsEntity();
        BeanUtils.copyProperties(goodsAddVo, goodsEntity);
        goodsEntity.setStock(goodsAddVo.getStock());
        goodsEntity.setSales(0);
        goodsEntity.setIsOn(0);
        goodsEntity.setIsRecommend(0);
        goodsEntity.setCreateTime(DateUtil.date());
        goodsEntity.setUpdateTime(DateUtil.date());
        goodsEntity.setCategoryId(goodsAddVo.getCatId().get(2));
        goodsEntity.setCover(goodsAddVo.getCover().get(0).getResponse().getImageUrl());
        UserEntity userInfoByToken = userService.getUserInfoByToken(token);
        goodsEntity.setUserId(userInfoByToken.getId());
        this.save(goodsEntity);
    }

    @Override
    public void updateGoods(String goodsId, GoodsAddVo goodsAddVo) {
        GoodsEntity goodsEntity = this.getById(goodsId);
        BeanUtils.copyProperties(goodsAddVo, goodsEntity);
        goodsEntity.setUpdateTime(DateUtil.date());
        goodsEntity.setCategoryId(goodsAddVo.getCatId().get(2));
        if (goodsAddVo.getCover() != null && goodsAddVo.getCover().size() > 0) {
            goodsEntity.setCover(goodsAddVo.getCover().get(0).getResponse().getImageUrl());
        }
        this.updateById(goodsEntity);
    }

    @Override
    public GoodsAddVo getGoodsInfo(String goodsId) {
        GoodsEntity goodsEntity = this.getById(goodsId);
        GoodsAddVo goodsAddVo = new GoodsAddVo();
        //1、设置基本属性
        BeanUtils.copyProperties(goodsEntity, goodsAddVo);
        //2、设置catId集合
        Long categoryId = goodsEntity.getCategoryId();
        List<Long> catId = categoryService.getCatIdList(categoryId);
        goodsAddVo.setCatId(catId);
        return goodsAddVo;
    }

    @Override
    public void decreaseStock(List<DecreaseStockTo> list) {

        list.forEach(item -> {
            Long goodsId = item.getGoodsId();
            Integer goodsNum = item.getGoodsNum();
            GoodsEntity goodsEntity = this.getById(goodsId);
            goodsEntity.setStock(goodsEntity.getStock() - goodsNum);
            this.updateById(goodsEntity);
        });

    }
}




