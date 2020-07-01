package com.wlb.jp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlb.jp.entity.Hangyedongxiang;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 行业动态(Hangyedongxiang)表数据库访问层
 *
 * @author makejava
 * @since 2020-01-07 17:59:04
 */
@Repository
public interface HangyedongxiangDao extends BaseMapper<Hangyedongxiang> {

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Hangyedongxiang> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("hangyedongxiang")Hangyedongxiang hangyedongxiang);

}