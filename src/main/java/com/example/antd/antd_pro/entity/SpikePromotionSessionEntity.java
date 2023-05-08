package com.example.antd.antd_pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 限时购场次表
 * @TableName spike_promotion_session
 */
@TableName(value ="spike_promotion_session")
@Data
public class SpikePromotionSessionEntity implements Serializable {
    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 场次名称
     */
    private String name;

    /**
     * 每日开始时间
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    /**
     * 每日结束时间
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    /**
     * 启用状态：0->不启用；1->启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}