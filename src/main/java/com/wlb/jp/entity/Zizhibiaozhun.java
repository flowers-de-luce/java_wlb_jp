package com.wlb.jp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 资质标准表(Zizhibanli)实体类
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 10:45:39
 */
@Data
public class Zizhibiaozhun implements Serializable {

    private static final long serialVersionUID = 775724000105252440L;
    
    /**
    * 主键唯一值
    */
    @TableId(type = IdType.AUTO)
    private Integer id;


    private Integer sanliandongId;


    /*
  名称
  */
    @NotNull(message = "标准详情名称不能为空")
    private String name;

    /**
     * 标题
     */
    @NotNull(message = "描述不能为空")
    private String ms;

    /**
     * 图片
     */
    private String tp;

    /**
    * 作者出处
    */
    private String cc;
    /**
    * 点击量
    */
    private Integer djl;
    /**
    * 内容
    */
    @NotNull(message = "内容不能为空")
    private String nr;

    /**
     * 关键字
     */
    @NotNull(message = "关键字不能为空")
    private String gjz;

    /*
    * 是否置顶
    * */
    private Integer zd;
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