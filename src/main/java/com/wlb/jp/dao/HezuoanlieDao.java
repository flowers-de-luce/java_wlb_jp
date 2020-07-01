package com.wlb.jp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlb.jp.entity.Hezuoanlie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 合作案列表(Hezuoanlie)表数据库访问层
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 11:37:07
 */
@Repository
public interface HezuoanlieDao extends BaseMapper<Hezuoanlie> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Hezuoanlie queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param count 查询每页的天数
     * @param page 页码
     * @return 对象列表
     */
    List<Hezuoanlie> queryAllByLimit(@Param("count") int count, @Param("page") int page);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param hezuoanlie 实例对象
     * @return 对象列表
     */
    List<Hezuoanlie> queryAll(Hezuoanlie hezuoanlie);



    /**
     * 修改数据
     *
     * @param hezuoanlie 实例对象
     * @return 影响行数
     */
    int update(Hezuoanlie hezuoanlie);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}