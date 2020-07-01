package com.wlb.jp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wlb.jp.dao.ZizhibiaozhunDao;

import com.wlb.jp.entity.Sanliandong;
import com.wlb.jp.entity.Zizhibiaozhun;

import com.wlb.jp.service.SanliandongService;
import com.wlb.jp.service.ZizhibiaozhunService;
import com.wlb.jp.utils.ConstantPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资质标准查询 服务实现接口
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 11:37:07
 */

@Service
public class ZizhibiaozhunServiceImpl extends ServiceImpl<ZizhibiaozhunDao, Zizhibiaozhun> implements ZizhibiaozhunService {

   @Autowired
  private ZizhibiaozhunDao zizhibiaozhunDao;



   @Autowired
   private ConstantPool cp1;
    /*
     * 通过ID查询单条数据
     * */
    @Override
    public Zizhibiaozhun queryById(Integer id) {
        return zizhibiaozhunDao.selectById(id);
    }


    /*
     * 通过标题查询数据
     * */
    @Override
    public Zizhibiaozhun queryBybt(QueryWrapper<Zizhibiaozhun> queryWrapper) {
        return this.zizhibiaozhunDao.selectOne(queryWrapper);
    }

    /*
     * 通过f_id查询数据资质标准信息
     * */
    @Override
    public Zizhibiaozhun queryByfid(Integer fid) {
        QueryWrapper<Zizhibiaozhun> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sanliandong_id", fid);
        queryWrapper.select("id","sanliandong_id","name","ms","tp");
        Zizhibiaozhun zizhibiaozhun = this.zizhibiaozhunDao.selectOne(queryWrapper);
        if (zizhibiaozhun != null && !zizhibiaozhun.equals("")){
            zizhibiaozhun.setTp(cp1.IMAGES_ZZBZ_KC + zizhibiaozhun.getTp());
            return zizhibiaozhun;
        }else {
            return null;
        }
    }



    /*
     * 通过ff_id查询数据资质标准信息
     * */
    @Override
    public Zizhibiaozhun queryByffid(Integer ffid) {
        QueryWrapper<Zizhibiaozhun> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sanliandong_id", ffid);
        queryWrapper.select("id","sanliandong_id","name","ms","tp");
        Zizhibiaozhun zizhibiaozhun = this.zizhibiaozhunDao.selectOne(queryWrapper);

        if (zizhibiaozhun != null && !zizhibiaozhun.equals("")){
            zizhibiaozhun.setTp(cp1.IMAGES_ZZBZ_KC + zizhibiaozhun.getTp());
            return zizhibiaozhun;
        }else {
            return null;
        }
    }


    /*
     * 新增资质标准数据
     * */
    @Override
    public Zizhibiaozhun insertOne(Zizhibiaozhun zizhibiaozhun) {
     this.zizhibiaozhunDao.insert(zizhibiaozhun);

        return zizhibiaozhun;
    }

    /*
     * 修改资质标准数据
     * */
    @Override
    public Zizhibiaozhun updateOneZzbz(Zizhibiaozhun zizhibiaozhun) {
        int i = this.zizhibiaozhunDao.updateById(zizhibiaozhun);
        if (i == 1){
            return zizhibiaozhun;
        }else {
            return null;
        }
    }



    /*
     * 通过主键删除数据
     * */
    @Override
    public int deleteOneZzbz(Integer id) {
        int i = this.zizhibiaozhunDao.deleteById(id);
        return i;
    }


    /*
     * 通过sanliandong_id删除数据
     * */
    @Override
    public int deleteBySanId(Integer id) {
        QueryWrapper<Zizhibiaozhun> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sanliandong_id", id);
        return this.zizhibiaozhunDao.delete(queryWrapper);

    }
}
