package com.wlb.jp.controller;

import com.wlb.jp.entity.Zizhuchaxun;
import com.wlb.jp.service.ZizhuchaxunService;
import com.wlb.jp.utils.ConstantPool;
import com.wlb.jp.utils.ReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 自助查询(Zizhuchaxun)表控制层
 *
 * @author makejava
 * @since 2020-01-07 17:59:20
 */
@RestController
@RequestMapping("zizhuchaxun")
public class ZizhuchaxunController {
    /**
     * 服务对象
     */
    @Resource
    private ZizhuchaxunService zizhuchaxunService;
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
        Zizhuchaxun zizhuchaxun = this.zizhuchaxunService.queryById(id);
        if (zizhuchaxun != null ){
            return new ReturnType(cpl.CODE_200, "", zizhuchaxun);
        }else {
            return new ReturnType("", "查无此数据，请核实", "");
        }
    }


    /**
     * 添加
     * @param zizhuchaxun
     * @return
     */
    @PostMapping("add.sjld")
    public ReturnType insertsjld(@Validated  Zizhuchaxun zizhuchaxun) {
        Zizhuchaxun insert = this.zizhuchaxunService.insert(zizhuchaxun);
        if (insert!=null){
            return new ReturnType(cpl.CODE_200,"",insert);
        }else {
            return new ReturnType("", "插入失败", "");
        }
    }

    /*
     *   通过主键删除数据
     * @Param:
     * @return:
     */

    @PostMapping("/delete.one")
    public ReturnType deleteOne(Integer id){
        boolean deleteById = this.zizhuchaxunService.deleteById(id);
        if (deleteById){
            return new ReturnType(cpl.CODE_200, " ", deleteById);
        }else {
            return new ReturnType("", "删除失败", "");
        }
    }

}