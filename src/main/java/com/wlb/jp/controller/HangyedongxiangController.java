package com.wlb.jp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wlb.jp.entity.Hangyedongxiang;
import com.wlb.jp.service.HangyedongxiangService;
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
import java.util.Map;

/**
 * 行业动态(Hangyedongxiang)表控制层
 *
 * @author makejava
 * @since 2020-01-07 17:59:05
 */
@RestController
@RequestMapping("hangyedongxiang")
public class HangyedongxiangController {
    /**
     * 服务对象
     */
    @Resource
    private HangyedongxiangService hangyedongxiangService;
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
        Hangyedongxiang hangyedongxiang = hangyedongxiangService.queryById(id);
        if (hangyedongxiang != null) {
            hangyedongxiang.setTp(cpl.IMAGES_HYDT_KC + hangyedongxiang.getTp());
            return new ReturnType(cpl.CODE_200, "", hangyedongxiang);
        }
        return new ReturnType("","获取失败","");
    }


    /**
     * 添加数据
     * @param hangyedongxiang 对象参数
     * @param image 图片
     * @return 实列对象
     */
    @PostMapping("add")
    public ReturnType insert(@Validated  Hangyedongxiang hangyedongxiang, @RequestParam(value = "image",required = true)  MultipartFile image){
        String uploadFile = Utils.uploadFile(image, cpl.IMAGES_HYDT);
        if (uploadFile != null){
            hangyedongxiang.setTp(uploadFile);
            Hangyedongxiang insert = this.hangyedongxiangService.insert(hangyedongxiang);
            if ( insert != null){
                return new ReturnType(cpl.CODE_200, "", insert);
            }else {
                return new ReturnType("", "添加失败", "");
            }
        }else {
            return new ReturnType("", "图片上传失败", "");
        }
    }

    /**
     * 修改数据
     * @param hangyedongxiang 对象参数
     * @param image 图片
     * @return 实列对象
     */
    @PostMapping("update")
    public ReturnType update(@Validated Hangyedongxiang hangyedongxiang, @RequestParam(value = "image",required = false)  MultipartFile image){
        if (hangyedongxiang.getId()!=null) {
            if (image != null && image.getSize() > 0) {
                String uploadFile = Utils.uploadFile(image, cpl.IMAGES_HYDT);
                if (uploadFile != null) {
                    hangyedongxiang.setTp(uploadFile);
                }
            }else {
                hangyedongxiang.setTp(null);
            }
            QueryWrapper<Hangyedongxiang> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", hangyedongxiang.getId());
            Hangyedongxiang update = this.hangyedongxiangService.update(hangyedongxiang, queryWrapper);
            if (update != null) {

                return new ReturnType(cpl.CODE_200, "", update);
            } else {
                return new ReturnType("", "修改失败", "");
            }
        }else {
            return new ReturnType("", "唯一值不能为空", "");
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
        int i = this.hangyedongxiangService.deleteById(id);
        if (i == 1){
            return new ReturnType(cpl.CODE_200, "" , i);
        }else {
            return new ReturnType("", "查询失败", "");
        }
    }

    /**
     * 首页行业动态查询（依据分类）
     *
     * @return
     */
    @GetMapping("sy.select")
    public ReturnType selectsy() {
        List<Map<String, List<Hangyedongxiang>>> list = new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            HashMap<String, List<Hangyedongxiang>> mapMap = new HashMap<>();
            QueryWrapper<Hangyedongxiang> queryWrapperzd1 = new QueryWrapper<>();
            queryWrapperzd1.orderByDesc("create_date")
                    .eq("delete_flag",1).eq("type",i +1 );
            queryWrapperzd1.select("id", "type", "bt", "ms", "gjz", "tp", "nr", "zd", "tj", "delete_flag", "create_date", "update_date");
            List<Hangyedongxiang> hangyedongxiangList = this.hangyedongxiangService.selectsy(queryWrapperzd1);
            for (Hangyedongxiang hangyedongxiang : hangyedongxiangList) {
                if (hangyedongxiang.getTp() !=  null && !hangyedongxiang.getTp().isEmpty()){
                    hangyedongxiang.setTp(cpl.IMAGES_HYDT_KC + hangyedongxiang.getTp());
                }
            }
            mapMap.put("list"+(i+1), hangyedongxiangList);
            list.add(mapMap);
        }
        if (list.size() > 0){
            return new ReturnType(cpl.CODE_200, "", list);
        }else {
            return new ReturnType("", "查询失败", "");
        }
    }

    /*
     * 行业资讯查询（返回三条数据）
     *
     * */
    @GetMapping("/selecthydt3")
    public ReturnType selecthydt3(){
        HashMap<String, Object> hyzxMap = new HashMap<>();

        QueryWrapper<Hangyedongxiang> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_date")
                .eq("delete_flag",1).last("limit 3");
        List<Hangyedongxiang> hydxList = this.hangyedongxiangService.selecthydt3(queryWrapper);
        for (Hangyedongxiang hangyedongxiang : hydxList) {
            hangyedongxiang.setTp(cpl.IMAGES_HYDT_KC + hangyedongxiang.getTp());
        }
        return new ReturnType(cpl.CODE_200, "", hydxList);
    }

    /**
     * 行业动态分页查询
     *
     * @return
     */
    @PostMapping("select.hydt.by.limit")
    public ReturnType selecthydtbylimit( Integer page,
                                         Integer count,
                                         Integer type) {
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Hangyedongxiang> queryWrapperzd = new QueryWrapper<>();
        queryWrapperzd.orderByDesc("create_date")
//                .eq("delete_flag", 1).eq("type", type);
                .eq("delete_flag", 1);
        queryWrapperzd.select("id", "type", "bt", "ms", "gjz", "tp", "nr", "zd", "tj", "delete_flag", "create_date", "update_date");
        IPage<Hangyedongxiang> selecthydtlimit = this.hangyedongxiangService.selecthydtlimit(page, count, queryWrapperzd);
        for (Hangyedongxiang hangyedongxiang1 : selecthydtlimit.getRecords()) {
            hangyedongxiang1.setTp(cpl.IMAGES_HYDT_KC + hangyedongxiang1.getTp());
        }
        map.put("list", selecthydtlimit.getRecords());
        map.put("size", selecthydtlimit.getTotal());
        return new ReturnType(cpl.CODE_200, "", map);
    }


}