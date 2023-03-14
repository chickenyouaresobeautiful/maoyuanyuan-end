package com.example.antd.antd_pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class OrdersEntity implements Serializable {
    /**
     * 自增长主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 单号
     */
    private String orderNo;

    /**
     * 创建者
     */
    private Long userId;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}