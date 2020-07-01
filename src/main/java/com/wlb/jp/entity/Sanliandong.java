package com.wlb.jp.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 三级联动(Sanliandong)实体类
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-25 14:06:40
 */
@Data
public class Sanliandong implements Serializable {

    private static final long serialVersionUID = -77894514864044736L;
    
    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 父类id，一级是为0；不为空
    */
    @NotNull(message = "父类id不能为空")
    private Integer fId;
    /**
     * 父一类id，一级是为0；不为空
     */
    private Integer fFId;
    /**
    * 类别名称
    */
    @NotNull(message = "类别名称不能为空")
    private String name;

    /*
    * 资质简介
    * */
    private String jj;

  /*
  *  是否存在详情页  1-存在详情  0-不存在详情
  * */
  private Integer existDetail;

  /*
  * 数值排序
  * */
  private Integer number;
    /**
    * 状态，1显示，0不显示
    */
    private Object deleteFlag;
    /**
    * 创建时间
    */
    private Date createDate;
    /**
    * 更新时间
    */
    private Date updateDate;


    /**
     * 二级分类
     */
    @TableField(exist = false)
    private List<Sanliandong> erjiList;

    /*
    * 资质详情信息
    * */
    @TableField(exist = false)
    private Object zizhibiaozhun;

}