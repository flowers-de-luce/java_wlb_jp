package com.wlb.jp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wlb.jp.entity.Hangyedongxiang;
import com.wlb.jp.dao.HangyedongxiangDao;
import com.wlb.jp.service.HangyedongxiangService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 行业动态(Hangyedongxiang)表服务实现类
 *
 * @author makejava
 * @since 2020-01-07 17:59:05
 */
@Service("hangyedongxiangService")
public class HangyedongxiangServiceImpl implements HangyedongxiangService {
    @Resource
    private HangyedongxiangDao hangyedongxiangDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Hangyedongxiang queryById(Integer id) {
        return this.hangyedongxiangDao.selectById(id);
//        return this.hangyedongxiangDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Hangyedongxiang> queryAllByLimit(int offset, int limit,Hangyedongxiang hangyedongxiang) {

        return this.hangyedongxiangDao.queryAllByLimit(offset, limit,hangyedongxiang);
    }

    /**
     * 新增数据
     *
     * @param hangyedongxiang 实例对象
     * @return 实例对象
     */
    @Override
    public Hangyedongxiang insert(Hangyedongxiang hangyedongxiang) {
        hangyedongxiang.setDeleteFlag(1);
        hangyedongxiang.setCreateDate(new Date());
        hangyedongxiang.setUpdateDate(new Date());
        this.hangyedongxiangDao.insert(hangyedongxiang);
        if (hangyedongxiang.getId()!=null) {
            return hangyedongxiang;
        }else {
            return null;
        }
    }

    /**
     * 修改数据
     *
     * @param hangyedongxiang 实例对象
     * @return 实例对象
     */
    @Override
    public Hangyedongxiang update(Hangyedongxiang hangyedongxiang, QueryWrapper<Hangyedongxiang> queryWrapper) {
        hangyedongxiang.setUpdateDate(new Date());
        this.hangyedongxiangDao.update(hangyedongxiang,queryWrapper);
        return this.queryById(hangyedongxiang.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        int i = this.hangyedongxiangDao.deleteById(id);
        return i;
    }

    /**
     * 首页查询
     * @param queryWrapper 条件
     * @return 集合对象
     */
    @Override
    public List<Hangyedongxiang> selectsy(QueryWrapper<Hangyedongxiang> queryWrapper) {
        return this.hangyedongxiangDao.selectList(queryWrapper);
    }

    /**
     * 分页查询
     * @param page 页码
     * @param count  每页条数
     * @param queryWrapper 条件
     * @return 集合对象
     */
    @Override
    public IPage<Hangyedongxiang> selecthydtlimit(Integer page, Integer count, QueryWrapper<Hangyedongxiang> queryWrapper) {
        return this.hangyedongxiangDao.selectPage(new Page<>(page,count), queryWrapper);
    }


    /*
     * 行业资讯查询（返回三条数据）
     * */
    @Override
    public List<Hangyedongxiang> selecthydt3(QueryWrapper<Hangyedongxiang> queryWrapper) {
        return this.hangyedongxiangDao.selectList(queryWrapper);
    }
}