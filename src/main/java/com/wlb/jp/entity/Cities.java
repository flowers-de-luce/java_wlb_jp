package com.wlb.jp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotNull;

/* 行政地市区域表 --  实体类*/
@Data
@TableName("cities")
public class Cities implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 市级编号
     */
    @NotNull(message = "市级名称不能为null")
    private String cityid;

    /**
     * 市级名字
     */
    @NotNull(message = "市级名称不能为空")
    private String city;

    /**
     * 省级编号
     */
    @NotNull(message = "省级编号不能为空")
    private String provinceid;


}
