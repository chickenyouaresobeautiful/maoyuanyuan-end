package com.example.antd.antd_pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName order_details
 */
@TableName(value ="order_details")
@Data
public class OrderDetailsEntity implements Serializable {
    /**
     * 	自增长主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 单号
     */
    private String orderNo;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品标题
     */
    private String goodsTitle;

    /**
     * 商品封面
     */
    private String goodsCover;

    /**
     * 商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 购买商品数
     */
    private Integer goodsNum;

    /**
     * 总金额
     */
    private BigDecimal totalPrice;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}