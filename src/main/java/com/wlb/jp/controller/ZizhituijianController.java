package com.wlb.jp.controller;

import com.wlb.jp.entity.Zizhibiaozhun;
import com.wlb.jp.service.ZizhituijianService;
import com.wlb.jp.utils.ConstantPool;
import com.wlb.jp.utils.ReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: xu.jiabao
 * @date: 2020/6/28 19:20
 */
@RestController
@RequestMapping("/zizhituijian")
public class ZizhituijianController {

    @Autowired
    private ZizhituijianService zizhituijianService;

    @Autowired
    private ConstantPool cpl;


    /*
     *  查询首推资质信息
     * */
    @GetMapping("/firstPull")
    public ReturnType firstPull(){
        List<Zizhibiaozhun> zizhibiaozhunList = this.zizhituijianService.firstPull();
        if (zizhibiaozhunList != null && zizhibiaozhunList.size() > 0){
            return new ReturnType(cpl.CODE_200, "", zizhibiaozhunList);
        }else {
            return new ReturnType("", "查询限定条件不符合", "");
        }
    }

    /*
     * 查询行业必备资质
     * */
    @GetMapping("/necessary12")
    public ReturnType necessary12(){
        Map<String, Object> map = this.zizhituijianService.necessary12();
        if (map != null  && map.size()>0){
            return new ReturnType(cpl.CODE_200," ", map);
        }else {
            return new ReturnType("", "查询限定条件不符合", "");
        }
    }

    /*
     * 查询资质办理页，推荐资质信息
     * */
    @GetMapping("/selectedPull")
    public ReturnType selectedPull() {
        List<Zizhibiaozhun> zizhibiaozhunList = this.zizhituijianService.selectedPull();
        if (zizhibiaozhunList.size()>0){
            return new ReturnType(cpl.CODE_200,"",zizhibiaozhunList);
        }else {
            return new ReturnType("","查询限定条件不符合", "");
        }
    }
}
