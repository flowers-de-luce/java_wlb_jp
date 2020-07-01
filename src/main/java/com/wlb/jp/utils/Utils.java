package com.wlb.jp.utils;

import org.apiguardian.api.API;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: java_wlb_jjgl
 * @description: 工具类
 * @author: XiaoLong.Zhao
 * @create: 2020-01-09 14:33
 **/
//@Component
public class Utils {

    static Logger logger = LoggerFactory.getLogger(Utils.class);

    static String files="D:/Nginx/ZS/API/kkb/";

//    @Autowired
//    private static ConstantPool cpl;

    //获取uuid
    public static synchronized String getUUID() {
        String[] arg = UUID.randomUUID().toString().split("-");
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : arg) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    /**
     * 上传文件
     *
     * @param uploadFile 文件
     * @param savePath   保存图片的硬盘地址
     * @return newImageName 重新生成的图片的名称
     */
    public static String uploadFile(MultipartFile uploadFile, String savePath) {

        if (uploadFile.isEmpty()) {
            return null;
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //路径
        String imagePath = request.getSession().getServletContext().getRealPath(savePath);
//        String imagePath = request.getRealPath(cpl.getUploadFolder());
//        String imagePath = files+savePath;
        //String imagePath = savePath;
        //获取上传文件名
        String fileName = uploadFile.getOriginalFilename();
        //创建随机的文件名称
        String newImageName = Utils.getUUID();
        //获得上传文件的扩展名
        String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        File file = new File(imagePath + "\\" + newImageName + "." + extensionName);
        File fileParent = file.getParentFile();
        logger.info("文件上传路径：" + imagePath + "\\" + newImageName + "." + extensionName);
        if (!fileParent.exists()) {
            fileParent.mkdirs();
            fileParent.setWritable(true);
        }
        try {
            uploadFile.transferTo(file);
            return newImageName + "." + extensionName;
        } catch (IOException e) {
            return null;
        }
    }


    public static boolean isFile(String filepath) {
        File f = new File(filepath);
        return f.exists() && f.isFile();
    }

    public static boolean isDir(String dirPath) {
        File f = new File(dirPath);
        return f.exists() && f.isDirectory();
    }
    /**
     * 创建多级目录
     * @param path
     */
    public static void makeDirs(String path) {
        File file = new File(path);
        // 如果文件夹不存在则创建
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }else {
            System.out.println("创建目录失败："+path);
        }
    }
}
