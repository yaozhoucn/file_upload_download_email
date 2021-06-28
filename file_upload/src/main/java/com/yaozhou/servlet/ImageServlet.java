package com.yaozhou.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by WXHang on HANG at 2021/6/10 9:04
 * Desc：
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器3秒刷新一次
        resp.setHeader("refresh","3");
        //在内存中创建图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_BGR);
        //长，宽，颜色
        Graphics2D g = (Graphics2D) image.getGraphics();//画笔
        g.setColor(Color.white);
        g.fillRect(0,0,80,20);
        //给图片写数据
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,20));
        //写
        g.drawString(makeNum(),0,20);
        //告诉浏览器用图片的方式打开
        resp.setContentType("image/jpeg");
        //告诉浏览器不让缓存数据
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //把图片写给浏览器
        ImageIO.write(image, "jpeg", resp.getOutputStream());

        //生成一个随机数

    }
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(999999) + "";
        //防止随机数位数超过6位数
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <6-num.length() ; i++) {
            stringBuffer.append("0");
        }
         num = stringBuffer.toString() + num;
        return num;

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
