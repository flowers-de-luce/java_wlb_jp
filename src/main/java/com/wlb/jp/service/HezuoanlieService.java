package com.wlb.jp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wlb.jp.entity.Hezuoanlie;
import java.util.List;

/**
 * 合作案列表(Hezuoanlie)表服务接口
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 11:37:07
 */
public interface HezuoanlieService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Hezuoanlie queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param count 查询每页的天数
     * @param page 页码
     * @return 对象列表
     */
    List<Hezuoanlie> queryAllByLimit(int count, int page);

    /**
     * 新增数据
     *
     * @param hezuoanlie 实例对象
     * @return 实例对象
     */
    Hezuoanlie insert(Hezuoanlie hezuoanlie);

    /**
     * 修改数据
     *
     * @param hezuoanlie 实例对象
     * @return 实例对象
     */
    Hezuoanlie update(Hezuoanlie hezuoanlie);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Integer id);


    /**
     * 分页查询
     * @param page 页码
     * @param count  每页条数
     * @param queryWrapper 条件
     * @return 集合对象
     */
    IPage<Hezuoanlie> selecthzallimit(Integer page, Integer count, QueryWrapper<Hezuoanlie> queryWrapper);


}