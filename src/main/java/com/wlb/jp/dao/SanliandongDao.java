package com.wlb.jp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlb.jp.entity.Sanliandong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 三级联动(Sanliandong)表数据库访问层
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-25 14:06:40
 */
@Repository
public interface SanliandongDao extends BaseMapper<Sanliandong> {

}