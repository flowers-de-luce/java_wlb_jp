package com.wlb.jp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlb.jp.entity.Lianxifangshi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Lianxifangshi)表数据库访问层
 *
 * @author makejava
 * @since 2020-01-07 17:59:07
 */
@Repository
public interface LianxifangshiDao extends BaseMapper<Lianxifangshi> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Lianxifangshi queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Lianxifangshi> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param lianxifangshi 实例对象
     * @return 对象列表
     */
    List<Lianxifangshi> queryAll(Lianxifangshi lianxifangshi);


    /**
     * 修改数据
     *
     * @param lianxifangshi 实例对象
     * @return 影响行数
     */
    int update(Lianxifangshi lianxifangshi);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}