package com.wlb.jp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wlb.jp.entity.Zizhibiaozhun;

import com.wlb.jp.service.ZizhibiaozhunService;

import com.wlb.jp.utils.ConstantPool;
import com.wlb.jp.utils.ReturnType;
import com.wlb.jp.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;


/**
 * 资质标准查询 控制器层接口
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 11:37:07
 */
@Validated
@RestController
@RequestMapping("/zizhibiaozhun")
public class ZizhibiaozhunController {

    @Autowired
    private ZizhibiaozhunService zizhibiaozhunService;

    @Autowired
    private ConstantPool cpl;

    /*
     * 通过ID查询单条数据
     * */
    @GetMapping("/select.one")
    public ReturnType selectOne(Integer id){
        Zizhibiaozhun zizhibiaozhun = this.zizhibiaozhunService.queryById(id);
        if (zizhibiaozhun != null &&  !zizhibiaozhun.equals("")){
            return new ReturnType(cpl.CODE_200, "" , zizhibiaozhun);
        }else {
            return new ReturnType("", "查询失败", "");
        }
    }

    /*
     * 通过二级标题查询数据
     * */
    @PostMapping("/select.one.by.bt")
    public ReturnType selectOneBybt(@NotNull(message = "标题不能为空") String bt){
        QueryWrapper<Zizhibiaozhun> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bt", bt);
        Zizhibiaozhun zizhibiaozhun = this.zizhibiaozhunService.queryBybt(queryWrapper);
        if (zizhibiaozhun != null){
            if (zizhibiaozhun.getTp() != null && !zizhibiaozhun.getTp().equals("")){
                zizhibiaozhun.setTp(cpl.IMAGES_ZZBZ_KC + zizhibiaozhun.getTp());
            }
            return new ReturnType(cpl.CODE_200, " " , zizhibiaozhun);
        }else {
            return new ReturnType("", "查询无数据", "");
        }
    }



    /*
     * 新增资质标准详情数据
     * */
    @Transactional
    @PostMapping("/insert.one.zzbz")
    public ReturnType insertOneZzbz(@Validated  Zizhibiaozhun zizhibiaozhun, @RequestParam(value = "image",required = false) MultipartFile image){
        if (image != null && image.getSize() > 0){
            String uploadFile = Utils.uploadFile(image, cpl.IMAGES_ZZBL);
            if (uploadFile != null){
                zizhibiaozhun.setTp(uploadFile);
            }
        }
        Zizhibiaozhun zizhibiaozhunA = this.zizhibiaozhunService.insertOne(zizhibiaozhun);
        if (zizhibiaozhunA.getId() != null && !zizhibiaozhunA.getId().equals(" ")){
            return new ReturnType(cpl.CODE_200, " ", zizhibiaozhunA);
        }else {
            return new ReturnType("" , "添加失败", "");
        }
    }

    /*
     * 修改资质标准数据
     * */
    @Transactional
    @PostMapping("/update.one.zzbz")
    public ReturnType updateOneZzbz(@Validated Zizhibiaozhun zizhibiaozhun, @RequestParam(value = "image",required = false)MultipartFile image){
        if (zizhibiaozhun.getId() != null){
            if (image != null && image.getSize() > 0){
                String uploadFile = Utils.uploadFile(image, cpl.IMAGES_ZZBL);
                if (uploadFile != null){
                    zizhibiaozhun.setTp(uploadFile);
                }
            }
            Zizhibiaozhun zizhibiaozhunA = this.zizhibiaozhunService.updateOneZzbz(zizhibiaozhun);
            if (zizhibiaozhunA != null){
                return new ReturnType(cpl.CODE_200,"", zizhibiaozhunA);
            }else {
                return new ReturnType("", "修改失败", "");
            }
        }else {
            return new ReturnType("", "唯一值不能为空", "");
        }
    }

    /*
     * 通过主键删除数据
     * */

    @PostMapping("/delete.one.zzbz")
    public ReturnType deleteOneZzbz(Integer id){
        try {
            int i = this.zizhibiaozhunService.deleteOneZzbz(id);
            return new ReturnType(cpl.CODE_200, "", i);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnType("", "删除失败", "");
        }
    }

}
