package com.wlb.jp.service.impl;
import com.wlb.jp.dao.CitiesMapper;
import com.wlb.jp.entity.Cities;
import com.wlb.jp.service.CitiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 行政区域地州市信息表 服务实现类
 * </p>
 *
 * @author author
 * @since 2020-06-18
 */
@Slf4j
@Service
public class CitiesServiceImpl  implements CitiesService {

    @Autowired
    private CitiesMapper citiesMapper;


    /*
     * 查询所有城市列表信息
     *
     * @return 城市列表信息
     * */
    @Override
    public List<Cities> queryAll() {
        return citiesMapper.queryAll();
    }

}
