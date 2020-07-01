package com.wlb.jp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wlb.jp.entity.Hezuoanlie;
import com.wlb.jp.service.HezuoanlieService;
import com.wlb.jp.utils.ConstantPool;
import com.wlb.jp.utils.ReturnType;
import com.wlb.jp.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 合作案列表(Hezuoanlie)表控制层
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-24 11:37:07
 */
@RestController
@RequestMapping("hezuoanlie")
public class HezuoanlieController {
    /**
     * 服务对象
     */
    @Resource
    private HezuoanlieService hezuoanlieService;
    /**
     * 常量池
     */
    @Autowired
    private ConstantPool cpl;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ReturnType selectOne(Integer id) {
        Hezuoanlie hezuoanlie = this.hezuoanlieService.queryById(id);
        if (hezuoanlie.getTp() != null && !hezuoanlie.getTp().equals("")){
            hezuoanlie.setTp(cpl.IMAGES_HZAL_KC + hezuoanlie.getTp());
        }
        return new ReturnType(cpl.CODE_200, "", hezuoanlie);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @PostMapping("select.hzal.by.limit")
    public ReturnType selecthzalbylimit(Integer page, Integer count) {
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Hezuoanlie> queryWrapperzd = new QueryWrapper<>();
        queryWrapperzd.orderByDesc("create_date")
                .eq("delete_flag", 1);
        queryWrapperzd.select("id", "bt", "tp", "ms", "gjz", "nr", "delete_flag", "create_date", "update_date");
        IPage<Hezuoanlie> selecthydtlimit = this.hezuoanlieService.selecthzallimit(page, count, queryWrapperzd);
        for (Hezuoanlie hezuoanlie : selecthydtlimit.getRecords()) {
            hezuoanlie.setTp(cpl.IMAGES_HZAL_KC + hezuoanlie.getTp());
        }
        map.put("list", selecthydtlimit.getRecords());
        map.put("size", selecthydtlimit.getTotal());
        return new ReturnType(cpl.CODE_200, "", map);
    }

    /**
     * 首页查询8条
     *
     * @return
     */
    @GetMapping("select.hzal.sy")
    public ReturnType selecthzalbysy() {
        List<Hezuoanlie> list = new ArrayList<>();
        QueryWrapper<Hezuoanlie> queryWrapperzd = new QueryWrapper<>();
        queryWrapperzd.orderByDesc("create_date")
                .eq("delete_flag", 1);
        queryWrapperzd.select("id", "bt", "tp", "ms", "gjz", "nr", "delete_flag", "create_date", "update_date");
        IPage<Hezuoanlie> selecthydtlimit = this.hezuoanlieService.selecthzallimit(0, 8, queryWrapperzd);
        for (Hezuoanlie hezuoanlie : selecthydtlimit.getRecords()) {
            hezuoanlie.setTp(cpl.IMAGES_HZAL_KC + hezuoanlie.getTp());
        }
        list = selecthydtlimit.getRecords();
        return new ReturnType(cpl.CODE_200, "", list);
    }

    /**
     * 添加
     *
     * @param hezuoanlie
     * @param image
     * @return
     */
    @PostMapping("add.hzal")
    public ReturnType addhzal(@Validated Hezuoanlie hezuoanlie, @RequestParam(value = "image", required = true) MultipartFile image) {
        if (image != null && image.getSize() > 0) {
            String uploadFile = Utils.uploadFile(image, cpl.IMAGES_HZAL);
            if (uploadFile != null) {
                hezuoanlie.setTp(uploadFile);
                Hezuoanlie insert = this.hezuoanlieService.insert(hezuoanlie);
                if (insert != null) {
                    return new ReturnType(cpl.CODE_200, "", insert);
                } else {
                    return new ReturnType("", "添加失败", "");
                }
            } else {
                return new ReturnType("", "图片上传失败", "");
            }
        } else {
            return new ReturnType("", "图片不能为空", "");
        }
    }


    /**
     * 修改
     *
     * @param hezuoanlie
     * @param image
     * @return
     */
    @PostMapping("update.hzal")
    public ReturnType updatehzal(Hezuoanlie hezuoanlie, @RequestParam(value = "image", required = false) MultipartFile image) {
        if (image != null && image.getSize() > 0) {
            String uploadFile = Utils.uploadFile(image, cpl.IMAGES_HZAL);
            if (uploadFile != null) {
                hezuoanlie.setTp(uploadFile);
            } else {
                hezuoanlie.setTp(null);
            }
        }
        Hezuoanlie insert = this.hezuoanlieService.update(hezuoanlie);
        if (insert != null) {
            return new ReturnType(cpl.CODE_200, "", insert);
        } else {
            return new ReturnType("", "修改失败", "");
        }
    }

        /**
         * 通过主键删除单条数据
         *
         * @param id 主键
         * @return 单条数据
         */
        @PostMapping("delete.one")
        public ReturnType deleteOne(Integer id) {
            int deleteById = this.hezuoanlieService.deleteById(id);
            if (deleteById == 1){
                return new ReturnType(cpl.CODE_200,"", deleteById);
            }else {
                return new ReturnType("", "删除失败，请稍后重试", "");
            }
        }
    }