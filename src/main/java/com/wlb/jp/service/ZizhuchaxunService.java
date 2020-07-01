package com.wlb.jp.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wlb.jp.entity.Zizhuchaxun;
import java.util.List;

/**
 * 自助查询(Zizhuchaxun)表服务接口
 *
 * @author makejava
 * @since 2020-01-07 17:59:19
 */
public interface ZizhuchaxunService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Zizhuchaxun queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Zizhuchaxun> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param zizhuchaxun 实例对象
     * @return 实例对象
     */
    Zizhuchaxun insert(Zizhuchaxun zizhuchaxun);

    /**
     * 修改数据
     *
     * @param zizhuchaxun 实例对象
     * @return 实例对象
     */
    Zizhuchaxun update(Zizhuchaxun zizhuchaxun);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询多条数据
     *
     * @param queryWrapper 查询起始位置
     * @return 对象列表
     */
    List<Zizhuchaxun> selectAll(QueryWrapper<Zizhuchaxun>queryWrapper);


}