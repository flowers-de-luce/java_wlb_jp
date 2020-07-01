package com.wlb.jp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wlb.jp.dao.ZizhibiaozhunDao;
import com.wlb.jp.entity.Sanliandong;
import com.wlb.jp.dao.SanliandongDao;
import com.wlb.jp.entity.Zizhibiaozhun;
import com.wlb.jp.service.SanliandongService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 三级联动(Sanliandong)表服务实现类
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-25 14:06:40
 */
@Service("sanliandongService")
public class SanliandongServiceImpl implements SanliandongService {
    @Resource
    private SanliandongDao sanliandongDao;

    @Resource
    private ZizhibiaozhunDao zizhibiaozhunDao;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sanliandong selectById(Integer id) {
        return this.sanliandongDao.selectById(id);

     /*   if (sanliandong.getExistDetail() ==1) {
            QueryWrapper<Zizhibiaozhun> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("sanliandong_id", sanliandong.getId());
            Zizhibiaozhun zizhibiaozhun = this.zizhibiaozhunDao.selectOne(queryWrapper);
            if (zizhibiaozhun.getId() != null) {
                sanliandong.setZizhibiaozhun(zizhibiaozhun);
            }
            return sanliandong;
        } else {
           return sanliandong;
        }*/
    }

    /**
     * 查询通过父类id
     * @param fid 父类id
     * @return
     */
    @Override
    public List<Sanliandong> selectsldbyfid(Integer fid){
        QueryWrapper<Sanliandong>queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("f_id",fid).eq("delete_flag",1);
//        queryWrapper.orderByDesc("create_date");
        queryWrapper.orderBy(true,true,"create_date");
        queryWrapper.select(Sanliandong.class, i -> !"erji_list".equals(i.getColumn()));
        List<Sanliandong> sanliandongList = this.sanliandongDao.selectList(queryWrapper);
        return sanliandongList;
    }

    /**
     * 查询多条数据
     *
     * @param queryWrapper 查询起始位置
     * @return 对象列表
     */
    @Override
    public List<Sanliandong> selectAll(QueryWrapper<Sanliandong> queryWrapper){
        return this.sanliandongDao.selectList(queryWrapper);
    }

    /**
     * 新增数据
     *
     * @param sanliandong 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Sanliandong insert(Sanliandong sanliandong) {
        sanliandong.setCreateDate(new Date());
        sanliandong.setUpdateDate(new Date());
        this.sanliandongDao.insert(sanliandong);
        return sanliandong;
    }


    /**
     * 修改数据
     *
     * @param sanliandong 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public Sanliandong update(Sanliandong sanliandong) {
        this.sanliandongDao.updateById(sanliandong);
        return this.selectById(sanliandong.getId());
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public Integer deleteById(Integer id) {
        int i = this.sanliandongDao.deleteById(id);
        return i;
    }

    /*
     * 资质服务导航栏--数据树
     * */
    @Override
    public List<Sanliandong> selectNavTree(QueryWrapper<Sanliandong> queryWrapper) {
        return this.sanliandongDao.selectList(queryWrapper);
    }

}