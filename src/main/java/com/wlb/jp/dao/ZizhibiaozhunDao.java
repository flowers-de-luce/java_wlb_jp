package com.wlb.jp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlb.jp.entity.Zizhibiaozhun;
import org.springframework.stereotype.Repository;

/*
* 资质标准表数据库访问层
* */

@Repository
public interface ZizhibiaozhunDao extends BaseMapper<Zizhibiaozhun> {
    /*
    * 新增资质标准数据
    * */
    int insertZzbz(Zizhibiaozhun zizhibiaozhun);
}
