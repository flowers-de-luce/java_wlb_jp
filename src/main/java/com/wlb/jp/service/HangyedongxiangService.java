package com.wlb.jp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wlb.jp.entity.Hangyedongxiang;
import java.util.List;

/**
 * 行业动态(Hangyedongxiang)表服务接口
 *
 * @author makejava
 * @since 2020-01-07 17:59:04
 */
public interface HangyedongxiangService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Hangyedongxiang queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Hangyedongxiang> queryAllByLimit(int offset, int limit,Hangyedongxiang hangyedongxiang);

    /**
     * 新增数据
     *
     * @param hangyedongxiang 实例对象
     * @return 实例对象
     */
    Hangyedongxiang insert(Hangyedongxiang hangyedongxiang);

    /**
     * 修改数据
     *
     * @param hangyedongxiang 实例对象
     * @return 实例对象
     */
    Hangyedongxiang update(Hangyedongxiang hangyedongxiang, QueryWrapper<Hangyedongxiang> queryWrapper);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Integer id);

    /**
     * 首页查询
     * @param queryWrapper 条件
     * @return 集合对象
     */
    List<Hangyedongxiang> selectsy(QueryWrapper<Hangyedongxiang> queryWrapper);




    /**
     * 分页查询
     * @param page 页码
     * @param count  每页条数
     * @param queryWrapper 条件
     * @return 集合对象
     */
    IPage<Hangyedongxiang> selecthydtlimit(Integer page, Integer count, QueryWrapper<Hangyedongxiang> queryWrapper);

    /*
     * 行业资讯查询（返回三条数据）
     * */
    List<Hangyedongxiang> selecthydt3(QueryWrapper<Hangyedongxiang> queryWrapper);

}