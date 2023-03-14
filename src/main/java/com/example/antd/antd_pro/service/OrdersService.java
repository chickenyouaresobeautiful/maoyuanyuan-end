package com.example.antd.antd_pro.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.entity.OrderDetailsEntity;
import com.example.antd.antd_pro.entity.OrdersEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.antd.antd_pro.vo.OrderShipVo;
import com.example.antd.antd_pro.vo.OrdersResponseVo;

import java.util.List;
import java.util.Map;

/**
* @author David
* @description 针对表【orders】的数据库操作Service
* @createDate 2023-03-13 16:53:07
*/
public interface OrdersService extends IService<OrdersEntity> {

    Page<OrdersResponseVo> getOrderList(Map<String, Object> params);

    List<OrderDetailsEntity> getOrderDetails(String orderNo);

    void orderShip(String orderNo, OrderShipVo orderShipVo);
}
