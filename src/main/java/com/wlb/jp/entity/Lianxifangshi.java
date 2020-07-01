package com.wlb.jp.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * (Lianxifangshi)实体类
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 10:45:38
 */
@Data
public class Lianxifangshi implements Serializable {

    private static final long serialVersionUID = 177459496000968603L;
    
    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 联系方式
    */
    @NotNull(message = "联系方式不能为空")
    private String phone;
    /**
    * 公司地址
    */
    @NotNull(message = "公司地址不能为空")
    private String dz;
    /**
    * 备案号
    */
    @NotNull(message = "备案号不能为空")
    private String bah;
    /**
    * 公司名称
    */
    @NotNull(message = "公司名称不能为空")
    private String mc;
    /**
    * 状态，1显示，0不显示
    */
    private Integer deleteFlag;
    /**
    * 创建时间
    */
    private Date createDate;
    /**
    * 更新时间
    */
    private Date updateDate;


}