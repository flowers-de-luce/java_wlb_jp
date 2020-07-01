package com.wlb.jp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wlb.jp.entity.Hezuoanlie;
import com.wlb.jp.dao.HezuoanlieDao;
import com.wlb.jp.service.HezuoanlieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 合作案列表(Hezuoanlie)表服务实现类
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 11:37:07
 */
@Service("hezuoanlieService")
public class HezuoanlieServiceImpl implements HezuoanlieService {
    @Resource
    private HezuoanlieDao hezuoanlieDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Hezuoanlie queryById(Integer id) {
        return this.hezuoanlieDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param count 查询每页的天数
     * @param page 页码
     * @return 对象列表
     */
    @Override
    public List<Hezuoanlie> queryAllByLimit(int count, int page) {
        return this.hezuoanlieDao.queryAllByLimit((count-1)*page, page);
    }

    /**
     * 新增数据
     *
     * @param hezuoanlie 实例对象
     * @return 实例对象
     */
    @Override
    public Hezuoanlie insert(Hezuoanlie hezuoanlie) {
        hezuoanlie.setDeleteFlag(1);
        hezuoanlie.setCreateDate(new Date());
        hezuoanlie.setUpdateDate(new Date());
        this.hezuoanlieDao.insert(hezuoanlie);
        return hezuoanlie;
    }

    /**
     * 修改数据
     *
     * @param hezuoanlie 实例对象
     * @return 实例对象
     */
    @Override
    public Hezuoanlie update(Hezuoanlie hezuoanlie) {
        hezuoanlie.setUpdateDate(new Date());
        this.hezuoanlieDao.update(hezuoanlie);
        return this.queryById(hezuoanlie.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        int i = this.hezuoanlieDao.deleteById(id);
        return i;
    }

    /**
     * 分页查询
     * @param page 页码
     * @param count  每页条数
     * @param queryWrapper 条件
     * @return
     */
    @Override
    public IPage<Hezuoanlie> selecthzallimit(Integer page, Integer count, QueryWrapper<Hezuoanlie> queryWrapper) {
        return this.hezuoanlieDao.selectPage(new Page<>(page,count), queryWrapper);
    }


}