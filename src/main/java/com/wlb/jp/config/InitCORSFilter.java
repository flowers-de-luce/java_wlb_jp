package com.wlb.jp.config;

/**
 * Created with IDEA
 * author: zhaoxiaolong
 * Date:2018/4/4 0004
 * Time:上午 11:38
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * CORSFilter 解决跨域问题
 * @author xiaolong.zhao
 *
 */
@Configuration
public class InitCORSFilter implements Filter {
    //读取配置文件
    public static Properties prop = null;


    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        String [] allowDomain= aa();
        Set<String> allowedOrigins= new HashSet<String>(Arrays.asList(allowDomain));
        String originHeader=((HttpServletRequest) req).getHeader("Origin");
        if (allowedOrigins.contains(originHeader)) {
            response.setHeader("Access-Control-Allow-Origin", originHeader);
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", " Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            chain.doFilter(req, res);
        }else   if (originHeader==null||originHeader.equals(null)||"null".equals(originHeader)){
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", " Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            chain.doFilter(req, res);
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
    public String [] aa(){
        if(prop == null){
            prop = new Properties();
            try {
                ClassPathResource classPathResource = new ClassPathResource("/InitCORSFilter.properties");   //这里的填写的参数是配置文件的相对路径
                prop.load(new InputStreamReader(classPathResource.getInputStream(),"utf-8"));     //文件流的编码方式
            }catch (IOException e){
                e.printStackTrace();
            }
            return prop.getProperty("id").split(",");
        }
        return prop.getProperty("id").split(",");
    }



}

