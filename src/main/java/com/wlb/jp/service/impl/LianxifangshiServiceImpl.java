package com.wlb.jp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wlb.jp.entity.Lianxifangshi;
import com.wlb.jp.dao.LianxifangshiDao;
import com.wlb.jp.service.LianxifangshiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Lianxifangshi)表服务实现类
 *
 * @author makejava
 * @since 2020-01-07 17:59:08
 */
@Service("lianxifangshiService")
public class LianxifangshiServiceImpl implements LianxifangshiService {
    @Resource
    private LianxifangshiDao lianxifangshiDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Lianxifangshi queryById(Long id) {
        return this.lianxifangshiDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Lianxifangshi> queryAllByLimit(int offset, int limit) {
        return this.lianxifangshiDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param lianxifangshi 实例对象
     * @return 实例对象
     */
    @Override
    public Lianxifangshi insert(Lianxifangshi lianxifangshi) {
        lianxifangshi.setCreateDate(new Date());
        lianxifangshi.setUpdateDate(new Date());
        lianxifangshi.setDeleteFlag(1);
        this.lianxifangshiDao.insert(lianxifangshi);
        if (lianxifangshi.getId()!=null){
            return lianxifangshi;
        }else {
            return null;
        }
    }

    /**
     * 修改数据
     *
     * @param lianxifangshi 实例对象
     * @return 实例对象
     */
    @Override
    public Lianxifangshi update(Lianxifangshi lianxifangshi) {
        lianxifangshi.setUpdateDate(new Date());
        this.lianxifangshiDao.update(lianxifangshi);
        return this.queryById(lianxifangshi.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.lianxifangshiDao.deleteById(id) > 0;
    }

    /**
     * 查询最新一个联系方式
     *
     * @return 实例对象
     */
    @Override
    public Lianxifangshi selectonelxfs() {
        QueryWrapper<Lianxifangshi>queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_date");
        queryWrapper.eq("delete_flag","1");
        List<Lianxifangshi> lianxifangshiList = this.lianxifangshiDao.selectList(queryWrapper);
        if (lianxifangshiList.size()>0){
            return lianxifangshiList.get(0);
        }
        return null;
    }

    @Override
    public List<Lianxifangshi> selectlxfslist() {
        QueryWrapper<Lianxifangshi>queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_date");
        queryWrapper.eq("delete_flag","1");
        List<Lianxifangshi> lianxifangshiList = this.lianxifangshiDao.selectList(queryWrapper);
//        if (lianxifangshiList.size()>0){
//            return lianxifangshiList.get(0);
//        }
        return lianxifangshiList;
    }
}