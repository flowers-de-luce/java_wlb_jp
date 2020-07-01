package com.wlb.jp.service;

import com.wlb.jp.entity.Cities;

import java.util.List;

/**
 * <p>
 * 行政区域地州市信息表 服务类
 * </p>
 *
 * @author author
 * @since 2020-06-18
 */
public interface CitiesService  {

    /*
     * 查询所有城市列表信息
     *
     * @return 城市列表信息
     * */
    List<Cities> queryAll();


}
