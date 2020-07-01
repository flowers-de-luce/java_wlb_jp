package com.wlb.jp.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 行业动态(Hangyedongxiang)实体类
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 10:45:37
 */
@Data
public class Hangyedongxiang implements Serializable {

    private static final long serialVersionUID = -57712593536847558L;
    
    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 类别（1；2；3）
    */
    @NotNull(message = "类型不能为空")
    @Digits(integer = 2, fraction = 0)
    @Min(value = 0)
    private String type;
    /**
    * 标题
    */
    @NotNull(message = "标题不能为空")
    private String bt;
    /**
    * 描述
    */
    @NotNull(message = "描述不能为空")
    private String ms;
    /**
    * 关键字
    */
    @NotNull(message = "关键字不能为空")
    private String gjz;
    /**
    * 图片
    */
    private String tp;
    /**
    * 内容
    */
    @NotNull(message = "内容不能为空")
    private String nr;
    /**
    * 置顶（1是，0否）
    */
    private Integer zd;
    /**
    * 推荐（1是，0否）
    */
    private Integer tj;
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