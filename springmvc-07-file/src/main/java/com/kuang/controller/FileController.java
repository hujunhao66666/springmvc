package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class FileController {

    @RequestMapping("/upload")
    public String upload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //获取文件名
        String uploadFileName = file.getOriginalFilename();
        //为空则返回到首页
        if ("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名"+uploadFileName);

        //上传路径保存
        String path = request.getServletContext().getRealPath("/upload");

        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);

        InputStream inputStream = file.getInputStream();//文件输入流
        FileOutputStream fileOutputStream = new FileOutputStream(new File(realPath, uploadFileName));//文件输出流

        //读取写出
        int len=0;
        byte[] buffer=new byte[1024];
        while ((len=inputStream.read(buffer))!=-1){
            fileOutputStream.write(buffer,0,len);
            fileOutputStream.flush();
        }
        fileOutputStream.close();
        inputStream.close();

        return "redirect:/index.jsp";
    }

    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IOException{
        String path=request.getServletContext().getRealPath("/upload");
        File file1 = new File(path);
        if (!file1.exists()){
            file1.mkdir();
        }

        System.out.println("上传文件保存地址："+file1);

        //通过CommonsMultipartFile的方法直接写文件
        file.transferTo(new File(file1+"/"+file.getOriginalFilename()));
        return "redirect:/index.jsp";

    }
}
