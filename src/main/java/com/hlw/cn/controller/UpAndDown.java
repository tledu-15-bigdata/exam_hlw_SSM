package com.hlw.cn.controller;

import com.hlw.cn.service.UploadAndDownload.Upload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UpAndDown {

    //上传文件
    @RequestMapping("/UpLoad")
    public void upLoad(HttpServletRequest request){
        Upload.upload(request);
    }

////    下载文件
//    @RequestMapping("/DownLoad")
//    public void downLoad(HttpServletRequest request, HttpServletResponse response){
//        Download.download(request,response);
//    }
//
//    //遍历文件
//    @RequestMapping("/ListMyFile")
//    public void listMyFile(HttpServletRequest request, HttpServletResponse response){
//        Download.listMyFile(request,response);
//    }
}
