package com.hlw.cn.service.UploadAndDownload;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class Download {

    //文件下载
    public  static void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realFileName=request.getParameter("filename");
        System.out.println(realFileName);
        //获取存储文件的路径

        String fileSaveRootPath=request.getServletContext().getRealPath("/uploadFile");

        String path=makePath(fileSaveRootPath);
        File file=new File(path+"\\"+realFileName);
        System.out.println(file.getPath());
        if(!file.exists()){
            System.out.println("您下载的文件不存在！！！！");
            return;
        }

        //存在情况，生成输出流开始下载
        String originFileName=realFileName.substring(realFileName.lastIndexOf("_")+1);
        //实现响应  及输出流设置
        //响应  设定响应头， 固定格式
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(originFileName,"UTF-8"));

        //按照真实名称  设定输入流读取要下载文件
        FileInputStream in=new FileInputStream(path+"\\"+realFileName);
        OutputStream out=response.getOutputStream();
        byte[] buffer =new byte[1024];
        int len=0;
        while((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        out.flush();
        out.close();
        in.close();


    }

    //设定文件存储路径：按照时间划分
    public static String makePath(String savePath){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");

        //遍历查找到该文件的文件夹名称
        String datePath=sdf.format();

        String dir=savePath+"\\"+datePath;
        File file=new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
        return dir;
    }

    //文件遍历
    public  static void listMyFile(HttpServletRequest request, HttpServletResponse response){
        String uploadFielPath = request.getServletContext().getRealPath("/uploadfile");
        System.out.println(uploadFielPath);
        //存储文件信息
        Map<String,String> map=new HashMap<String, String>();

        listFile(new File(uploadFielPath),map);
        request.setAttribute("fileNameMap",map);
        //有待商定


    }

    //递归遍历
    public static void listFile(File file,Map<String,String> map){
        if (!file.isFile()){
            //递归遍历
            File[] files=file.listFiles();
            for (File file1:files){
                listFile(file1,map);
            }
        }
        else {
            //不显示uuid
            String realName=(file.getName().substring(file.getName().lastIndexOf("_"))+1);
            map.put(file.getName(),realName);
        }

    }


}
