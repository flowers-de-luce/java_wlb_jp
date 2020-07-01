package com.wlb.jp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlb.jp.entity.Zizhuyy;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 自助（地市）查询 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2020-06-18
 */
@Repository
public interface ZizhuyyMapper extends BaseMapper<Zizhuyy> {

    /*
    * 通过ID查询单条数据
    *
    * @param id 主键
    * @return 实例对象
    * */
    Zizhuyy queryById(Long id);


    /*
    * 查询指定行数据
    *
    * @param offect 查询起始位置
    * @param limit 查询条数
    * @return 对象列表
    * */
    List<Zizhuyy> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

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
     * @return 影响行数
     * */
    int insertOne(Zizhuyy zizhuyy);

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
    int deleteById(Long id);

}
