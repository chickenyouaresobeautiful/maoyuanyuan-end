package com.example.antd.antd_pro.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.entity.GoodsEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.antd.antd_pro.to.DecreaseStockTo;
import com.example.antd.antd_pro.vo.GoodsAddVo;

import java.util.List;
import java.util.Map;

/**
* @author admin
* @description 针对表【goods】的数据库操作Service
* @createDate 2023-03-10 14:12:22
*/
public interface GoodsService extends IService<GoodsEntity> {

    Page<GoodsEntity> getGoods(Map<String, Object> params);

    void isOn(String goodId);

    void isRecommend(String goodId);

    void addGoods(GoodsAddVo goodsAddVo, String token);

    void updateGoods(String goodsId, GoodsAddVo goodsAddVo);

    GoodsAddVo getGoodsInfo(String goodsId);

    void decreaseStock(List<DecreaseStockTo> list);
}
