package com.yaozhou.servlet.fileDownload;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by WXHang on HANG at 2021/6/9 14:58
 * Desc：
 */
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.定义文件路径
        String realPath = "D:\\搜狗高速下载\\壁纸\\好图1920x1080.jpg";
        //2.获取文件的名称
        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
        System.out.println(fileName);
        //3.让浏览器支持下载我们所需要的东西
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));

        //4.获取文件的输入流
        FileInputStream inputStream = new FileInputStream(realPath);
        //5.创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        //6.获取outputsteam对象
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len=inputStream.read(buffer))> 0){
            outputStream.write(buffer,0,len);
        }
        //6.输出
        inputStream.close();
        outputStream.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
