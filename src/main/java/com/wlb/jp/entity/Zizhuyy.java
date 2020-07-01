package com.wlb.jp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotNull;

@Data
@TableName("zizhuyy")
public class Zizhuyy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 地市
     */
    @NotNull(message = "地市不能为空")
    private String ds;

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
