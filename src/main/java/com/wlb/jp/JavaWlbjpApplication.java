package com.wlb.jp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan({"com.wlb.jp.dao"})
@EnableTransactionManagement  //开启事务管理
public class JavaWlbjpApplication {


    public static void main(String[] args) {
        SpringApplication.run(JavaWlbjpApplication.class, args);
    }

//    public void add(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/**").addResourceLocations();
//        super.addResourceHandlers(registry);
//    }

        @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大   KB,MB
        factory.setMaxFileSize(DataSize.parse("100MB"));
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("500MB"));
        return factory.createMultipartConfig();
    }

}
