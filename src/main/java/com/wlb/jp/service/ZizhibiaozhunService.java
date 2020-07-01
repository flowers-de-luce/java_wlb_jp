package com.wlb.jp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wlb.jp.entity.Zizhibiaozhun;

import java.util.List;

/**
 * 资质标准查询 服务接口
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 11:37:07
 */
public interface ZizhibiaozhunService  extends IService<Zizhibiaozhun> {

    /*
    * 通过ID查询单条数据
    * */
    Zizhibiaozhun queryById(Integer id);

    /*
    * 通过标题查询数据
    * */
    Zizhibiaozhun queryBybt(QueryWrapper<Zizhibiaozhun> queryWrapper);


    /*
    * 通过ff_id查询数据
    * */
    Zizhibiaozhun queryByffid(Integer ffid);

    /*
    * 通过f_id查询数据
    * */
    Zizhibiaozhun queryByfid(Integer fid);

    /*
    * 新增资质标准数据
    * */
    Zizhibiaozhun insertOne(Zizhibiaozhun zizhibiaozhun);

    /*
    * 修改资质标准数据
    * */
    Zizhibiaozhun updateOneZzbz(Zizhibiaozhun zizhibiaozhun);

    /*
    * 通过主键删除数据
    * */
    int deleteOneZzbz(Integer id);

    /*
    * 通过sanliandong_id删除数据
    * */

    int deleteBySanId(Integer id);


}


