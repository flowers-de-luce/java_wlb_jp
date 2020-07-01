package com.wlb.jp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wlb.jp.entity.Sanliandong;
import java.util.List;

/**
 * 三级联动(Sanliandong)表服务接口
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-25 14:06:40
 */
public interface SanliandongService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sanliandong selectById(Integer id);

    /**
     * 查询通过父类id
     * @param fid 父类id
     * @return
     */
    List<Sanliandong> selectsldbyfid(Integer fid);

    /**
     * 查询多条数据
     *
     * @param queryWrapper 查询起始位置
     * @return 对象列表
     */
    List<Sanliandong> selectAll(QueryWrapper<Sanliandong> queryWrapper);


    /**
     * 新增数据
     *
     * @param sanliandong 实例对象
     * @return 实例对象
     */
    Sanliandong insert(Sanliandong sanliandong);

    /**
     * 修改数据
     *
     * @param sanliandong 实例对象
     * @return 实例对象
     */
    Sanliandong update(Sanliandong sanliandong);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    Integer deleteById(Integer id);

    /*
     * 资质服务导航栏--数据树
     * */
    List<Sanliandong> selectNavTree(QueryWrapper<Sanliandong> queryWrapper);


}