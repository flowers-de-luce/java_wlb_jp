package com.wlb.jp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlb.jp.entity.Zizhuchaxun;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自助查询(Zizhuchaxun)表数据库访问层
 *
 * @author makejava
 * @since 2020-01-07 17:59:18
 */
@Repository
public interface ZizhuchaxunDao extends BaseMapper<Zizhuchaxun> {



    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Zizhuchaxun> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param zizhuchaxun 实例对象
     * @return 对象列表
     */
    List<Zizhuchaxun> queryAll(Zizhuchaxun zizhuchaxun);



    /**
     * 修改数据
     *
     * @param zizhuchaxun 实例对象
     * @return 影响行数
     */
    int update(Zizhuchaxun zizhuchaxun);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}