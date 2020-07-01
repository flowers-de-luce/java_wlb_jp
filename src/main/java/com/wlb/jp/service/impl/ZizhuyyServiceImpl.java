package com.wlb.jp.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wlb.jp.dao.ZizhuyyMapper;
import com.wlb.jp.entity.Hangyedongxiang;
import com.wlb.jp.entity.Zizhuyy;
import com.wlb.jp.service.ZizhuyyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.assertj.core.util.DateUtil.now;

/**
 * <p>
 * 自助（地市）查询 服务实现类
 * </p>
 *
 * @author author
 * @since 2020-06-18
 */

@Service
public class ZizhuyyServiceImpl implements ZizhuyyService {
    @Autowired
    ZizhuyyMapper zizhuyyMapper;

    /*
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     * */
    @Override
    public Zizhuyy queryById(Integer id) {
        return null;
    }
    /*
     * 查询指定行数据
     *
     * @param offect 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     * */
    @Override
    public List<Zizhuyy> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 分页查询预约信息
     * @param page 页码
     * @param count  每页条数
     * @param queryWrapper 条件
     * @return 集合对象
     */
    @Override
    public IPage<Zizhuyy> selecthydtlimit(Integer page, Integer count, QueryWrapper<Zizhuyy> queryWrapper) {
        return this.zizhuyyMapper.selectPage(new Page<>(page, count), queryWrapper);
    }


    /*
     * 通过实体作为筛选条件查询
     *
     * @param zizhuyy 实例对象
     * @return 影响行数
     * */
    @Override
    public List<Zizhuyy> queryAll(Zizhuyy zizhuyy) {
        return null;
    }
    /*
     * 插入自助查询数据
     *
     * @param zizhuyy 实例对象
     * @return 影响行数
     * */
    @Override
    public Zizhuyy insertOne(@NotNull(message = "地市名称不能为空") String city,
                             @NotNull(message = "手机号不能为空") String phone) {
        Zizhuyy zizhuyy = new Zizhuyy();
        zizhuyy.setDs(city);
        zizhuyy.setPhone(phone);
        zizhuyy.setDeleteFlag(1);
        zizhuyy.setCreateDate(now());
        zizhuyy.setUpdateDate(now());
        this.zizhuyyMapper.insert(zizhuyy);
        return zizhuyy;
    }
    /**
     * 修改数据
     *
     * @param zizhuyy 实例对象
     * @return 影响行数
     */
    @Override
    public int update(Zizhuyy zizhuyy) {
        return 0;
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @Override
    public int deleteById(Integer id) {
        return this.zizhuyyMapper.deleteById(id);
    }
}
