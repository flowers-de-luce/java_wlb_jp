package com.wlb.jp.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 合作案列表(Hezuoanlie)实体类
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 10:45:38
 */
@Data
public class Hezuoanlie implements Serializable {

    private static final long serialVersionUID = 984256960753682864L;
    
    /**
    * 唯一值
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 标题
    */
    @NotNull(message = "标题不能为空")
    private String bt;
    /**
    * 内容
    */
    @NotNull(message = "内容不能为空")
    private String nr;
    /**
    * 图片
    */
    private String tp;
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