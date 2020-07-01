package com.wlb.jp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wlb.jp.entity.Sanliandong;
import com.wlb.jp.entity.Zizhibiaozhun;
import com.wlb.jp.service.SanliandongService;
import com.wlb.jp.service.ZizhibiaozhunService;
import com.wlb.jp.utils.ConstantPool;
import com.wlb.jp.utils.ReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 三级联动(Sanliandong)表控制层
 *
 * @author Zhao.XiaoLong
 * @since 2020-03-25 14:06:40
 */
@RestController
@RequestMapping("sanliandong")
public class SanliandongController {
    /**
     * 服务对象
     */
    @Resource
    private SanliandongService sanliandongService;

    @Autowired
    private ZizhibiaozhunService zizhibiaozhunService;

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
    @PostMapping("selectOne")
    public ReturnType selectOne(Integer id) {
        Sanliandong sanliandong = this.sanliandongService.selectById(id);
        if (sanliandong != null) {
            return new ReturnType(cpl.CODE_200, "", sanliandong);
        } else {
            return new ReturnType("", "查询失败", "");
        }
    }

    /**
     * 三联动查询
     *
     * @param fid
     * @return
     */
    @PostMapping("select.sld.by.fid")
    public ReturnType selectsldbyfid(Integer fid) {
        if (fid != null) {
            List<Sanliandong> sanliandongList = this.sanliandongService.selectsldbyfid(fid);
            if (sanliandongList.size() > 0) {
                return new ReturnType(cpl.CODE_200, "", sanliandongList);
            } else {
                return new ReturnType("", "暂无数据", "");
            }
        } else {
            return new ReturnType("", "父类id不能为空", "");
        }
    }


    /**
     * 添加三级联动
     *
     * @param sanliandong 对象参数
     * @return
     */
    @PostMapping("add")
    private ReturnType insert(@Validated Sanliandong sanliandong) {
        Sanliandong insert = this.sanliandongService.insert(sanliandong);
        if (insert != null) {
            return new ReturnType(cpl.CODE_200, "", insert);
        } else {
            return new ReturnType("", "添加失败，请稍后重试", "");
        }
    }


    /**
     * 修改三级联动
     *
     * @param sanliandong 对象参数
     * @return
     */
    @PostMapping("update")
    private ReturnType update(@Validated Sanliandong sanliandong) {
        if (sanliandong.getId() != null) {
            Sanliandong insert = this.sanliandongService.update(sanliandong);
            if (insert != null) {
                return new ReturnType(cpl.CODE_200, "", insert);
            } else {
                return new ReturnType("", "修改失败，请稍后重试", "");
            }
        } else {
            return new ReturnType("", "id不能为空", "");
        }
    }


    /**
     * 通过主键删除单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("delete.one")
    @Transactional
    public ReturnType deleteOne(Integer id) {
        Sanliandong sanliandong = this.sanliandongService.selectById(id);
        if (sanliandong.getExistDetail() == 1) {
            int i = this.zizhibiaozhunService.deleteBySanId(sanliandong.getId());
            Integer deleteById = this.sanliandongService.deleteById(id);
            return new ReturnType(cpl.CODE_200, "", "影响行数为： " + deleteById);
        } else {
            Integer deleteById = this.sanliandongService.deleteById(id);
            return new ReturnType(cpl.CODE_200, "", "影响行数为： " + deleteById);
        }
    }

    /**
     * 三联动查询list
     *
     * @return
     */
    @GetMapping("select.sld.list")
    public ReturnType selectsldlist() {
        List<Sanliandong> sanliandongList1 = null;

        QueryWrapper<Sanliandong> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.orderByDesc("f_id").orderByDesc("create_date");
        queryWrapper1.eq("delete_flag", "1");
        queryWrapper1.eq("f_id", "0");
        queryWrapper1.select(Sanliandong.class, i -> !"erji_list".equals(i.getColumn()));
        sanliandongList1 = this.sanliandongService.selectAll(queryWrapper1);
        for (Sanliandong sanliandong : sanliandongList1) {
            QueryWrapper<Sanliandong> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.orderByDesc("f_id").orderByDesc("create_date");
            queryWrapper2.eq("delete_flag", "1");
            queryWrapper2.eq("f_id", sanliandong.getId());
            queryWrapper2.select(Sanliandong.class, i -> !"erji_list".equals(i.getColumn()));
            List<Sanliandong> sanliandongList2 = this.sanliandongService.selectAll(queryWrapper2);
            sanliandong.setErjiList(sanliandongList2);
            for (Sanliandong sanliandong1 : sanliandongList2) {
                QueryWrapper<Sanliandong> queryWrapper3 = new QueryWrapper<>();
                queryWrapper3.orderByDesc("f_id").orderByDesc("create_date");
                queryWrapper3.eq("delete_flag", "1");
                queryWrapper3.eq("f_id", sanliandong1.getId());
                queryWrapper3.select(Sanliandong.class, i -> !"erji_list".equals(i.getColumn()));
                List<Sanliandong> sanliandongList3 = this.sanliandongService.selectAll(queryWrapper3);
                sanliandong1.setErjiList(sanliandongList3);
            }
        }
        if (sanliandongList1.size() > 0) {
            return new ReturnType(cpl.CODE_200, "", sanliandongList1);
        } else {
            return new ReturnType("", "父类id不能为空", "");
        }
    }

    /*
     * 资质服务导航栏--数据树
     * */
    @GetMapping("/select.nav.tree")
    public ReturnType selectNavTree() {
        // 构造数据树集合列表
        List<Sanliandong> navTreeList = null;

        //获取资质类型（一级）
        QueryWrapper<Sanliandong> queryWrapperA = new QueryWrapper<>();
        queryWrapperA.orderByDesc("f_id").orderByDesc("create_date")
                .eq("delete_flag", 1).eq("f_id", 0);
        navTreeList = this.sanliandongService.selectAll(queryWrapperA);

        // 构造资质类型（一级）的id字符串
        String ids1 = "";
        for (Sanliandong sanliandongA : navTreeList) {
            if (ids1 != "") {
                ids1 = ids1 + "," + sanliandongA.getId().toString();
            } else {
                ids1 = sanliandongA.getId().toString();
            }
        }

        // 构造资质名称（二级）的id字符串
        String ids2 = "";
        // 获取资质名称（二级）
        QueryWrapper<Sanliandong> queryWrapperB = new QueryWrapper<>();
        queryWrapperB.orderByDesc("f_id").orderByDesc("create_date")
                .eq("delete_flag", 1).in("f_id", ids1.split(","));
        List<Sanliandong> sanliandongListB = this.sanliandongService.selectAll(queryWrapperB);
        for (Sanliandong sanliandongB : sanliandongListB) {
            for (Sanliandong sanliandongA : navTreeList) {
                List<Sanliandong> list = new ArrayList<>();
                if (sanliandongB.getFId().equals(sanliandongA.getId())) {
                    list.add(sanliandongB);
                    if (sanliandongA.getErjiList() != null && !sanliandongA.getErjiList().isEmpty()) {
                        list.addAll(sanliandongA.getErjiList());
                    }
                    sanliandongA.setErjiList(list);
                }
            }
            if (ids2 != "") {
                ids2 = ids2 + "," + sanliandongB.getId().toString();
            } else {
                ids2 = sanliandongB.getId().toString();
            }
        }


        QueryWrapper<Zizhibiaozhun> queryWrapperD = new QueryWrapper<>();
        queryWrapperD.in("sanliandong_id", ids2.split(","));
        queryWrapperD.select("id","sanliandong_id","name","ms","tp");
        List<Zizhibiaozhun> zizhibiaozhunList = this.zizhibiaozhunService.list(queryWrapperD);


        for (Zizhibiaozhun zizhibiaozhun : zizhibiaozhunList) {
            for (Sanliandong sanliandongB : sanliandongListB) {
                if (zizhibiaozhun.getSanliandongId().equals(sanliandongB.getId())){
                    zizhibiaozhun.setTp(this.cpl.IMAGES_ZZBZ_KC + zizhibiaozhun.getTp());
                    if (sanliandongB.getExistDetail() == 1) {
                        sanliandongB.setZizhibiaozhun(zizhibiaozhun);
                    }
                }
            }
        }

        if (navTreeList.size() > 0) {
            return new ReturnType(cpl.CODE_200, "", navTreeList);
        } else {
            return new ReturnType("", "查询限定条件不符合", "");
        }
    }
}