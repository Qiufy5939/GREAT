<%@ page import="java.util.Random" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    //随机产生颜色
    public Color getColor(){
        Random ran = new Random();
        int r = ran.nextInt(256);
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);
        return new Color(r,g,b);
    }

    //产生验证码值
    public String getNum(){

        int ran = (int)(Math.random()*9000)+1000;
        return String.valueOf(ran);
    }

%>

<%
    //禁止缓存，防止验证码过期
    response.setHeader("pragma","no-cache");
    response.setHeader("cache-Control","no-cache");
    response.setHeader("Expires","0");

    //绘制验证码
    BufferedImage image = new BufferedImage(140,52,BufferedImage.TYPE_INT_RGB);

    //画笔
    Graphics graphics = image.getGraphics();
   // graphics.fillRect(0,0,160,60);
    graphics.setColor(Color.BLACK);
    graphics.fill3DRect(0, 0, 140,52, true);

    //绘制验证码
    graphics.setColor(Color.BLACK);
    String checkCode = getNum();
    StringBuffer sb = new StringBuffer();
    for (int i=0;i<checkCode.length();i++){
        //提取每位数字
        sb.append(checkCode.charAt(i)+" ");
    }
    //设置字体大小
    graphics.setFont(new Font("seif",Font.ITALIC,35));
    //设置字体颜色
    graphics.setColor(getColor());
    //开始画字体
    graphics.drawString(sb.toString(),16,39);

    //绘制干扰线条
    for (int i=0;i<60;i++){
        Random ran = new Random();
        int xBegin = ran.nextInt(160);
        int yBegin = ran.nextInt(60);

        int xEnd = ran.nextInt(xBegin+10);
        int yEnd = ran.nextInt(yBegin+10);

        graphics.setColor(getColor());
        //画线条
        graphics.drawLine(xBegin,yBegin,xEnd,yEnd);
    }

    //将验证码真实值 保存在session中，供使用者使用
    session.setAttribute("CHECKCODE",checkCode);

    //真实的产生图片
    ImageIO.write(image,"jpeg",response.getOutputStream());

    //关闭操作
    out.clear();
    out = pageContext.pushBody();//可以让自制的图片加入jsp中
%>