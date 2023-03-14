package com.example.antd.antd_pro.vo;

import com.example.antd.antd_pro.entity.UserEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrdersResponseVo {

    private Long id;

    /**
     * 单号
     */
    private String orderNo;

    /**
     * 创建者
     */
    private UserEntity userEntity;

    /**
     * 总价
     */
    private BigDecimal amount;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 收货地址
     */
    private Integer addressId;

    /**
     * 快递类型
     */
    private String expressType;

    /**
     * 快递号
     */
    private String expressNo;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 支付类型
     */
    private String payType;

    /**
     * 支付流水号
     */
    private String tradeNo;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;
}
