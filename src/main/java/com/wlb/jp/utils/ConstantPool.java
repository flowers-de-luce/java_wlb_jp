package com.wlb.jp.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName 常量池
 * @Author ZXlong
 * @Description //TODO 
 * @Date 15:54 2019/4/25
 * @return
 **/
@Configuration
@Data
public class ConstantPool {

    //返回结果状态
    @Value("${request.type.success}")
    public  String  CODE_200 ;//成功标识


    //行业状态路径
    @Value("${file.image.hydt.sc}")
    public  String  IMAGES_HYDT ;
    @Value("${file.image.hydt.kc}")
    public  String  IMAGES_HYDT_KC ;

    //资质办理专区路径
    @Value("${file.image.zzbl.sc}")
    public  String  IMAGES_ZZBL ;
    @Value("${file.image.zzbl.kc}")
    public  String  IMAGES_ZZBL_KC ;

    //资质标准路径
    @Value("${file.image.zzbz.sc}")
    public  String  IMAGES_ZZBZ ;
    @Value("${file.image.zzbz.kc}")
    public  String  IMAGES_ZZBZ_KC ;

    //合作案列路径
    @Value("${file.image.hzal.sc}")
    public  String  IMAGES_HZAL ;
    @Value("${file.image.hzal.kc}")
    public  String  IMAGES_HZAL_KC ;

    //资质推荐路径
    @Value("${file.image.zztj.sc}")
    public  String  IMAGES_ZZTJ ;
    @Value("${file.image.zztj.kc}")
    public  String  IMAGES_ZZTJ_KC ;


    @Value("${web.file.path}")
    private   String uploadFolder;


}
