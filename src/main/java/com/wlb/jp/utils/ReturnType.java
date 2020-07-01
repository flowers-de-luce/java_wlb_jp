package com.wlb.jp.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName 返回对象
 * @Author ZXlong
 * @Description //TODO 
 * @Date 15:55 2019/4/25
 * @return
 **/
@Data
@AllArgsConstructor
public class ReturnType {
    /**
     * 状态，比如：1成功
     */
    private String code;

    /**
     * 错误信息 比如：msg:请求数据失败   msg:用户未注册
     */
    private String msg;
    /**
     * 返回的json数据
     */
    private Object value;

}
