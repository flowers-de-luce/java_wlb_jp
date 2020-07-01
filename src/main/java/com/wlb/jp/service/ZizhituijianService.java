package com.wlb.jp.service;

import com.wlb.jp.entity.Zizhibiaozhun;

import java.util.List;
import java.util.Map;

/**
 * @description: 资质推荐
 * @author: xu.jiabao
 * @date: 2020/6/28 19:19
 */
public interface ZizhituijianService {

    /*
    *  查询首推资质信息
    * */
    List<Zizhibiaozhun> firstPull();

    /*
    * 查询行业必备资质
    * */
    Map<String, Object> necessary12();

    /*
    * 查询资质办理页，推荐资质信息
    * */

    List<Zizhibiaozhun> selectedPull();
}
