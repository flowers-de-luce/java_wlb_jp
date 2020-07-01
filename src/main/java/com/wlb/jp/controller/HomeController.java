package com.wlb.jp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wlb.jp.entity.Zizhuchaxun;
import com.wlb.jp.service.ZizhuchaxunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java_wlb_jjgl
 * @description: 后台数据展示
 * @author: XiaoLong.Zhao
 * @create: 2020-01-10 09:14
 **/
@RequestMapping()
@Controller
public class HomeController {


    @Autowired
    private ZizhuchaxunService zizhuchaxunService;


    /**delete
     * 后台数据查询
     * @param
     * @return
     */
    @GetMapping("home.select.list")
    public String selectlist(ModelMap map) {
        QueryWrapper<Zizhuchaxun>queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_date").eq("delete_flag",1);
        List<Zizhuchaxun> jianZaoShiBaoMingList = this.zizhuchaxunService.selectAll(queryWrapper);
        map.addAttribute("kkbList", jianZaoShiBaoMingList);
        map.addAttribute("title", "快快办管理列表");
        return "jp";
    }



}
