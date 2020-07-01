package com.wlb.jp.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 自助查询(Zizhuchaxun)实体类
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 10:45:39
 */
@Data
public class Zizhuchaxun implements Serializable {

    private static final long serialVersionUID = -62594653083014676L;
    
    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 专业
    */
    @NotNull(message = "资质类型不能为空")
    private String zy;
    /**
    * 等级
    */
    @NotNull(message = "资质等级不能为空")
    private String dj;
    /**
    * 名称
    */
    @NotNull(message = "资质名称不能为空")
    private String mc;
    /**
    * 手机号
    */
    @NotNull(message = "手机号不能为空")
    private String phone;
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