package com.wlb.jp.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlb.jp.entity.Cities;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 行政区域地州市信息表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2020-06-18
 */
@Repository
public interface CitiesMapper extends BaseMapper<Cities> {

    /*
     * 查询所有城市列表信息
     *
     * @return 城市列表信息
     * */
    List<Cities> queryAll();


}
