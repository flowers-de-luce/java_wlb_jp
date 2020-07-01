package com.wlb.jp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wlb.jp.entity.Zizhuchaxun;
import com.wlb.jp.dao.ZizhuchaxunDao;
import com.wlb.jp.service.ZizhuchaxunService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 自助查询(Zizhuchaxun)表服务实现类
 *
 * @author makejava
 * @since 2020-01-07 17:59:19
 */
@Service("zizhuchaxunService")
public class ZizhuchaxunServiceImpl implements ZizhuchaxunService {
    @Resource
    private ZizhuchaxunDao zizhuchaxunDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Zizhuchaxun queryById(Integer id) {
        return this.zizhuchaxunDao.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Zizhuchaxun> queryAllByLimit(int offset, int limit) {
        return this.zizhuchaxunDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param zizhuchaxun 实例对象
     * @return 实例对象
     */
    @Override
    public Zizhuchaxun insert(Zizhuchaxun zizhuchaxun) {
        zizhuchaxun.setCreateDate(new Date());
        zizhuchaxun.setUpdateDate(new Date());
        zizhuchaxun.setDeleteFlag(1);
        this.zizhuchaxunDao.insert(zizhuchaxun);
        if (zizhuchaxun.getId()!=null) {
            return zizhuchaxun;
        }else {
            return null;
        }
    }

    /**
     * 修改数据
     *
     * @param zizhuchaxun 实例对象
     * @return 实例对象
     */
    @Override
    public Zizhuchaxun update(Zizhuchaxun zizhuchaxun) {
        zizhuchaxun.setUpdateDate(new Date());
        this.zizhuchaxunDao.update(zizhuchaxun);
        return this.queryById(zizhuchaxun.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.zizhuchaxunDao.deleteById(id) > 0;
    }

    @Override
    public List<Zizhuchaxun> selectAll(QueryWrapper<Zizhuchaxun> queryWrapper) {
        return this.zizhuchaxunDao.selectList(queryWrapper);
    }
}