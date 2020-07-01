package com.wlb.jp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wlb.jp.entity.Zizhuyy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 自助(地市)查询 服务类
 * </p>
 *
 * @author author
 * @since 2020-06-18
 */
public interface ZizhuyyService {

    /*
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     * */
    Zizhuyy queryById(Integer id);

    /*
     * 查询指定行数据
     *
     * @param offect 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     * */
    List<Zizhuyy> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 分页查询预约信息
     * @param page 页码
     * @param count  每页条数
     * @param queryWrapper 条件
     * @return 集合对象
     */
    IPage<Zizhuyy> selecthydtlimit(Integer page, Integer count, QueryWrapper<Zizhuyy> queryWrapper);

    /*
     * 通过实体作为筛选条件查询
     *
     * @param zizhuyy 实例对象
     * @return 影响行数
     * */
    List<Zizhuyy> queryAll(Zizhuyy zizhuyy);
    /*
     * 插入自助查询数据
     *
     * @param zizhuyy 实例对象
     * @return 插入数据
     * */
    Zizhuyy insertOne(String city, String phone);

    /**
     * 修改数据
     *
     * @param zizhuyy 实例对象
     * @return 影响行数
     */
    int update(Zizhuyy zizhuyy);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


}
