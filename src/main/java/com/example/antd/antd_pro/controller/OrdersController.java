package com.example.antd.antd_pro.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.antd.antd_pro.entity.OrderDetailsEntity;
import com.example.antd.antd_pro.entity.OrdersEntity;
import com.example.antd.antd_pro.service.OrdersService;
import com.example.antd.antd_pro.utils.R;
import com.example.antd.antd_pro.vo.OrderShipVo;
import com.example.antd.antd_pro.vo.OrdersResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("list")
    public R list(@RequestParam Map<String, Object> params) {
        Page<OrdersResponseVo> orderPage = ordersService.getOrderList(params);
        return R.ok().put("orderPage", orderPage);
    }

    @GetMapping("details/{orderNo}")
    public R details(@PathVariable("orderNo") String orderNo) {
        List<OrderDetailsEntity> details = ordersService.getOrderDetails(orderNo);
        return R.ok().put("orderDetails", details);
    }

    @PutMapping("ship/{orderNo}")
    public R ship(@PathVariable("orderNo") String orderNo, @RequestBody OrderShipVo orderShipVo) {
        ordersService.orderShip(orderNo, orderShipVo);
        return R.ok();
    }
}
