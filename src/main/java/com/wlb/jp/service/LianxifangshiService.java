package com.wlb.jp.service;

import com.wlb.jp.entity.Lianxifangshi;
import java.util.List;

/**
 * (Lianxifangshi)表服务接口
 *
 * @author makejava
 * @since 2020-01-07 17:59:08
 */
public interface LianxifangshiService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Lianxifangshi queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Lianxifangshi> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param lianxifangshi 实例对象
     * @return 实例对象
     */
    Lianxifangshi insert(Lianxifangshi lianxifangshi);

    /**
     * 修改数据
     *
     * @param lianxifangshi 实例对象
     * @return 实例对象
     */
    Lianxifangshi update(Lianxifangshi lianxifangshi);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询最新一个联系方式
     * @return
     */
    Lianxifangshi selectonelxfs();


    /**
     * 查询联系方式
     * @return
     */
    List<Lianxifangshi> selectlxfslist();
}