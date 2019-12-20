package com.hbgc.loudbbs.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class MyUtils {
    //获取操作系统的名称
    public static String getOperateSysName(){
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            return "windows";
        }else{
            return "linux";
        }
    }
    //实现文件上传
    public static String uploadFile(MultipartFile file, String path) throws Exception{

        String fileName = file.getOriginalFilename(); //获得上传文件的文件名
        //使用UUID生成一个不重复的文件名字。
        String uploadFileName = createUUIDFileName(fileName);

        //先判断文件的父目录是否存在，如果不存在先创建目录
        File uploadFile = new File(path,uploadFileName);
        if(!uploadFile.getParentFile().exists()){
            uploadFile.getParentFile().mkdirs();
        }
        //在判断文件是否存在，如果存在先删除，再创建。
        if(uploadFile.exists()){
            uploadFile.delete();
        }
        uploadFile.createNewFile();

        file.transferTo(uploadFile); //也就是这一句话实现文件上传

        String filePath=path+uploadFile.getName();
        return filePath;

    }

    //获得上传成功后返回的UUID的文件名，避免用户之间重名的文件覆盖问题
    public static String createUUIDFileName(String fileName){
        String uuid =  UUID.randomUUID().toString().replace("-","");
        return uuid+fileName;
    }
}
