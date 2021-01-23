package com.hlw.cn.service.UploadAndDownload;

import com.hlw.cn.service.impl.UserServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class Upload {
    public static void upload(HttpServletRequest httpServletRequest){
        String acc=null;
        String realSvePath=null;
        UserServiceImpl userService = new UserServiceImpl();

        //上传文件环境准备
        //本地文件 传输到服务器
        String savePath=httpServletRequest.getServletContext().getRealPath("/uploadfile");

        //临时目录，缓存目录
        String tempPath=httpServletRequest.getServletContext().getRealPath("/tempfile");

        File tempFile = new File(tempPath);
        //文件不存在进行创建
        if (!tempFile.exists()){
            tempFile.mkdir();
        }

        //实现上传
        //apache问价上传组件  文件上传工厂
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //设置缓冲区：当上传的文件超过设定缓冲区的大小，需要指定一个临时目录进行存放上传过程中的数据流
        factory.setSizeThreshold(1023*100);
        //帮定上传的临时目录
        factory.setRepository(tempFile);

        //上传前的流格式内容准备
        //创建apache上传组件 上传解析器
        ServletFileUpload upload=new ServletFileUpload(factory);
        //进度监听
        upload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long haveesize, long totlesize  , int i) {
                System.out.println("文件大小为："+totlesize+"当前已处理"+haveesize);
            }
        });
        //设置编码格式
        upload.setHeaderEncoding("UTF-8");
        //判定当前请求携带上传的数据的流格式
        //if (!ServletFileUpload.isMultipartContent(httpServletRequest)) return;

        //单个文件最大1MB
        upload.setFileSizeMax(1024*1024);
        //设定总上传了
        upload.setSizeMax(1024*1024*10);

        //实现上传流解析
        try {
            List<FileItem> list=upload.parseRequest(httpServletRequest);
            for (FileItem item:list){
                //只是文本数据
                if (item.isFormField()){
                    //获取文本域 key
                    String name=item.getFieldName();
                    String value=item.getString("UTF-8");
                    System.out.println(name+"="+value);
                }else {
                    if ("acc".equals(item.getName())) acc=item.getString("UTF-8");
                    else {
                        //获取上传文件名称
                        String fileName=item.getName();
                        System.out.println("文件名称"+fileName);
                        if (fileName==null||fileName.trim().equals(""))continue;
                        //截取上传文件名称
                        fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
                        String fileSuffixName=fileName.substring(fileName.lastIndexOf(".")+1);
                        System.out.println("上传文件后缀"+fileSuffixName);

                        //获取上传文件输入流
                        InputStream in=item.getInputStream();
                        //设定真实保存文件名称
                        String saveFileName=makeFileName(fileName);

                        //获取最终存储路径+uuid的文件名称
                        realSvePath=makePath(savePath);
                        FileOutputStream outputStream=new FileOutputStream(realSvePath+"\\"+saveFileName);
                        //创建缓冲区
                        byte[] buffer=new byte[1024];
                        int len=0;
                        while ((len=in.read(buffer))!=-1){
                            outputStream.write(buffer,0,len);
                        }
                        outputStream.flush();
                        outputStream.close();
                        in.close();
                    }

                    //存入数据库将头像地址
                    if (realSvePath!=null && acc!=null) System.out.println(userService.addHeadsrc(realSvePath,acc));

                }
            }

        } catch (FileUploadException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    //fileName  UUID_xxxx.txt
    public static String makeFileName(String fileName){
        return UUID.randomUUID().toString()+"_"+fileName;
    }

    //设定文件存储路径：按照时间划分
    public static String makePath(String savePath){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String datePath=sdf.format(new Date());

        String dir=savePath+"\\"+datePath;
        File file=new File(dir);
        if(!file.exists()){
            file.mkdirs();
        }
        return dir;
    }
}
