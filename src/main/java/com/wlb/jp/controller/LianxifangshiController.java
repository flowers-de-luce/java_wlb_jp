package com.wlb.jp.controller;

import com.wlb.jp.entity.Lianxifangshi;
import com.wlb.jp.service.LianxifangshiService;
import com.wlb.jp.utils.ConstantPool;
import com.wlb.jp.utils.ReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * 联系方式(Lianxifangshi)表控制层
 *
 * @author makejava
 * @since 2020-01-07 17:59:09
 */
@RestController
@RequestMapping("lianxifangshi")
public class LianxifangshiController {
    /**
     * 服务对象
     */
    @Resource
    private LianxifangshiService lianxifangshiService;

    /**
     * 常量池
     */
    @Autowired
    private ConstantPool cpl;



    /**
     * 添加联系方式
     *
     * @param lianxifangshi 对象参数
     * @return
     */
    @PostMapping("addupdate")
    public ReturnType insert(@Validated Lianxifangshi lianxifangshi) {
        List<Lianxifangshi> selectlxfslist = this.lianxifangshiService.selectlxfslist();
        if (selectlxfslist.size()>0) {
            lianxifangshi.setId(selectlxfslist.get(0).getId());
            lianxifangshi.setUpdateDate(new Date(System.currentTimeMillis()));
            Lianxifangshi insert = this.lianxifangshiService.update(lianxifangshi);
            if (insert != null) {
                return new ReturnType(cpl.CODE_200, "", insert);
            } else {
                return new ReturnType("", "修改失败，请稍后重试", "");
            }

        }else {
            Lianxifangshi insert = this.lianxifangshiService.insert(lianxifangshi);
            if (insert != null) {
                return new ReturnType(cpl.CODE_200, "", insert);
            } else {
                return new ReturnType("", "添加失败，请稍后重试", "");
            }
        }
    }


    /**
     * 查询一个最新的符合条件的联系方式
     * @return
     */
    @GetMapping("select.one.new.lxfs")
    public ReturnType selectonelxfs(){
        Lianxifangshi selectonelxfs = null;

        Map<String,Object>map = new HashMap<>();
        selectonelxfs = this.lianxifangshiService.selectonelxfs();
        List<String> stringtolist = this.Stringtolist(selectonelxfs.getPhone());
        map.put("lxfs",selectonelxfs);
        map.put("list",stringtolist);

        if (map != null && !map.isEmpty()){
            return new ReturnType(cpl.CODE_200, "", map);
        }else {
            return new ReturnType("", "暂无数据", "");
        }
    }

    private  List<String> Stringtolist(String lianxifangshi){
        String[] split = lianxifangshi.split(",");
        List<String> list = new ArrayList<>();
        for (String lxfs:split){
            if (lxfs!=null&&!lxfs.isEmpty()){
                list.add(lxfs);
            }
        }
        return list;
    }

}