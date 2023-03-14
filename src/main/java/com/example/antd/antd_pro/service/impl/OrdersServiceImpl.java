package com.example.antd.antd_pro.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.antd.antd_pro.entity.OrderDetailsEntity;
import com.example.antd.antd_pro.entity.OrdersEntity;
import com.example.antd.antd_pro.entity.UserEntity;
import com.example.antd.antd_pro.service.GoodsService;
import com.example.antd.antd_pro.service.OrderDetailsService;
import com.example.antd.antd_pro.service.OrdersService;
import com.example.antd.antd_pro.mapper.OrdersMapper;
import com.example.antd.antd_pro.service.UserService;
import com.example.antd.antd_pro.to.DecreaseStockTo;
import com.example.antd.antd_pro.vo.OrderShipVo;
import com.example.antd.antd_pro.vo.OrdersResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author David
 * @description 针对表【orders】的数据库操作Service实现
 * @createDate 2023-03-13 16:53:07
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, OrdersEntity> implements OrdersService {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private GoodsService goodsService;

    @Override
    public Page<OrdersResponseVo> getOrderList(Map<String, Object> params) {
        QueryWrapper<OrdersEntity> queryWrapper = new QueryWrapper<>();
        if (params.get("orderNo") != null) {
            String orderNo = params.get("orderNo").toString();
            queryWrapper.eq("order_no", orderNo);
        }
        if (params.get("tradeNo") != null) {
            String tradeNo = params.get("tradeNo").toString();
            queryWrapper.eq("trade_no", tradeNo);
        }
        long current = Long.parseLong(params.get("current").toString());
        long pageSize = Long.parseLong(params.get("pageSize").toString());
        Page<OrdersEntity> page = this.page(new Page<>(current, pageSize), queryWrapper);

        //重新设置返回给前端的对象(需要用户信息)
        List<OrdersResponseVo> newRecords = page.getRecords().stream().map(item -> {
            OrdersResponseVo ordersResponseVo = new OrdersResponseVo();
            BeanUtils.copyProperties(item, ordersResponseVo);
            UserEntity userEntity = userService.getById(item.getUserId());
            ordersResponseVo.setUserEntity(userEntity);
            return ordersResponseVo;
        }).collect(Collectors.toList());

        Page<OrdersResponseVo> responsePage = new Page<>();
        BeanUtils.copyProperties(page, responsePage);
        responsePage.setRecords(newRecords);

        responsePage.setTotal(page.getRecords().size());
        return responsePage;
    }

    @Override
    public List<OrderDetailsEntity> getOrderDetails(String orderNo) {
        return orderDetailsService.list(
                new QueryWrapper<OrderDetailsEntity>()
                        .eq("order_no", orderNo)
        );
    }

    @Override
    public void orderShip(String orderNo, OrderShipVo orderShipVo) {
        //1、改变订单状态
        OrdersEntity ordersEntity = this.getOne(new QueryWrapper<OrdersEntity>().eq("order_no", orderNo));
        ordersEntity.setStatus(3);
        ordersEntity.setExpressNo(orderShipVo.getExpressNo());
        ordersEntity.setExpressType(orderShipVo.getExpressType());
        ordersEntity.setUpdateTime(DateUtil.date());
        this.updateById(ordersEntity);
        //2、减少商品库存
        List<DecreaseStockTo> list = getOrderDetails(orderNo).stream().map(item -> {
            DecreaseStockTo decreaseStockTo = new DecreaseStockTo();
            decreaseStockTo.setGoodsId(item.getGoodsId());
            decreaseStockTo.setGoodsNum(item.getGoodsNum());
            return decreaseStockTo;
        }).collect(Collectors.toList());

        goodsService.decreaseStock(list);

    }
}




