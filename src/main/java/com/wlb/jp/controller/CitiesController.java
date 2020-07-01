package com.wlb.jp.controller;


import com.wlb.jp.entity.Cities;
import com.wlb.jp.service.CitiesService;
import com.wlb.jp.utils.ConstantPool;
import com.wlb.jp.utils.ReturnType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 行政区域地州市信息表 前端控制器
 * </p>
 *
 * @author author
 * @since 2020-06-18
 */
@Slf4j
@RestController
@RequestMapping("cities")
public class CitiesController {

    /*
    * 服务对象
    * */
    @Autowired
    private CitiesService citiesService;
    /**
     * 常量池
     */
    @Autowired
    private ConstantPool cpl;
    /*
    * 查询所有城市列表信息
    *
    * @return 城市列表信息
    * */
    @GetMapping("/selectAll")
    public ReturnType selectAll(){
        List<Cities> citiesList = citiesService.queryAll();
        return new ReturnType(cpl.CODE_200,"",citiesList);
    }

}
