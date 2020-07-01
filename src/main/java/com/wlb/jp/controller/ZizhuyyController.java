package com.wlb.jp.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wlb.jp.entity.Zizhuyy;
import com.wlb.jp.service.ZizhuyyService;
import com.wlb.jp.utils.ConstantPool;
import com.wlb.jp.utils.ReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

import static org.assertj.core.util.DateUtil.now;

/**
 * <p>
 * 自助查询 前端控制器
 * </p>
 *
 * @author author
 * @since 2020-06-18
 */
@Validated
@RestController
@RequestMapping("/zizhuyy")
public class ZizhuyyController {

    /*
     * 服务对象
     * */
    @Autowired
    private ZizhuyyService zizhuyyService;

    /*
     * 常量池
     * */
    @Autowired
    private ConstantPool cpl;

    /*
     * 插入数据
     *
     * @param city 城市名称
     * @param phone 手机号码
     * */
    @PostMapping("/add")
    public ReturnType inseetOne( @NotNull(message = "地市名称不能为空") String city,
                                 @NotNull(message = "手机号不能为空") String phone) {
        Zizhuyy zizhuyy = this.zizhuyyService.insertOne(city, phone);
        if (zizhuyy.getId() != null){
            return  new ReturnType(cpl.CODE_200, "", zizhuyy);
        }else {
            return new ReturnType("","插入错误", "");
        }
    }

    /**
     * 分页查询预约信息
     * @param page 页码
     * @param count  每页条数
     * @return 集合对象
     */
    @PostMapping("/select.zizhuyy.by.limit")
    public ReturnType selecthydtbylimit( Integer page,
                                         Integer count){
        HashMap<String, Object> map = new HashMap<>();
        QueryWrapper<Zizhuyy> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_date")
                .eq("delete_flag",1);
        queryWrapper.select("id", "ds", "phone", "delete_flag", "create_date", "update_date");
        IPage<Zizhuyy> selectzzyylimit = this.zizhuyyService.selecthydtlimit(page, count, queryWrapper);
        map.put("list", selectzzyylimit.getRecords());
        map.put("size", selectzzyylimit.getTotal());
        return new ReturnType(cpl.CODE_200, "", map);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    @PostMapping("/delete.one")
    public ReturnType deleteOne(Integer id){
        int deleteById = this.zizhuyyService.deleteById(id);
        if (deleteById == 1){
            return new ReturnType(cpl.CODE_200,"", "");
        }else {
            return new ReturnType("", "删除失败", "");
        }
    }
}
