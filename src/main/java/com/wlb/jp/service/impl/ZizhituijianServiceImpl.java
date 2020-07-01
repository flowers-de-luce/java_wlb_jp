package com.wlb.jp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wlb.jp.dao.SanliandongDao;
import com.wlb.jp.dao.ZizhibiaozhunDao;
import com.wlb.jp.entity.Sanliandong;
import com.wlb.jp.entity.Zizhibiaozhun;
import com.wlb.jp.service.ZizhituijianService;
import com.wlb.jp.utils.ConstantPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: xu.jiabao
 * @date: 2020/6/28 19:20
 */

@Service
public class ZizhituijianServiceImpl implements ZizhituijianService {
    @Autowired
    private ZizhibiaozhunDao zizhibiaozhunDao;

    @Autowired
    private SanliandongDao sanliandongDao;
    @Autowired
    private ConstantPool cpl;

    /*
     *  查询首推资质信息
     * */
    @Override
    public List<Zizhibiaozhun> firstPull() {
        QueryWrapper<Zizhibiaozhun> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("djl","create_date")
                .eq("zd",1);
        queryWrapper.select("id", "name", "ms", "tp", "djl").last(" limit 10");
        List<Zizhibiaozhun> zizhibiaozhunList = zizhibiaozhunDao.selectList(queryWrapper);
        return zizhibiaozhunList;
    }

    /*
     * 查询行业必备资质
     * */
    @Override
    public Map<String, Object> necessary12() {
        Map<String, Object> dataMap = new HashMap<>();
        QueryWrapper<Sanliandong> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("number")
                .eq("delete_flag", 1)
                .eq("f_id", 0)
                .last(" limit  3");
        queryWrapper.select("id", "name", "jj","number");
        List<Sanliandong> sanliandongList = this.sanliandongDao.selectList(queryWrapper);

        // 添加一级资质类型
        dataMap.put("first", sanliandongList);

        List<Integer> arrayList = new ArrayList<>();

        for (Sanliandong sanliandong : sanliandongList) {
            arrayList.add(sanliandong.getId());
        }


        for (int i = 0; i < arrayList.size(); i++) {
            QueryWrapper<Sanliandong> queryWrapperB= new QueryWrapper<>();
            queryWrapperB.orderByDesc("number")
                    .eq("delete_flag",1)
                    .eq("f_id",arrayList.toArray()[i])
                    .last("limit 4");
            queryWrapperB.select("id","f_id","name","exist_detail","number");
            List<Sanliandong> sanliandongListB = this.sanliandongDao.selectList(queryWrapperB);

            for (Sanliandong sanliandong : sanliandongListB) {
                if (sanliandong.getExistDetail() == 1) {
                    QueryWrapper<Zizhibiaozhun> queryWrapperC = new QueryWrapper<>();
                    queryWrapperC.eq("sanliandong_id", sanliandong.getId());
                    queryWrapperC.select("id","sanliandong_id","name","ms","tp");
                    Zizhibiaozhun zizhibiaozhun = this.zizhibiaozhunDao.selectOne(queryWrapperC);
                    if (zizhibiaozhun.getTp() != null){
                        zizhibiaozhun.setTp(cpl.IMAGES_ZZBZ_KC+ zizhibiaozhun.getTp());
                    }
                    sanliandong.setZizhibiaozhun(zizhibiaozhun);
                }
            }
            dataMap.put("second"+i, sanliandongListB);
        }
        return dataMap;
    }

    /*
     * 查询资质办理页，推荐资质信息
     * */
    @Override
    public List<Zizhibiaozhun> selectedPull() {
        QueryWrapper<Zizhibiaozhun> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("djl","create_date")
                .eq("zd",-1)
                .last("limit 10");
        queryWrapper.select("id", "name", "ms", "tp", "djl","zd");
        List<Zizhibiaozhun> zizhibiaozhunList = this.zizhibiaozhunDao.selectList(queryWrapper);
        return zizhibiaozhunList;
    }
}
