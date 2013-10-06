package com.tmp.gateway;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;

import java.util.Random;
import javax.imageio.ImageIO;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	 public void init(ServletConfig config) throws ServletException{
		 super.init(config);
		 System.out.println("initialized Captcha controller");
	 }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int width = 150;
    int height = 50;
    char data[]={'z','e', 't', 'c', 'o', 'd', 'e','l', 'i', 'n', 'u', 'x','f', 'r', 'e', 'e', 'b', 's', 'd','u', 'b', 'u', 'n', 't', 'u','j', 'e', 'e','a','0','2','3','4','5','w'};
    /*char data[][] = {
        { 'z', 'e', 't', 'c', 'o', 'd', 'e' },
        { 'l', 'i', 'n', 'u', 'x' },
        { 'f', 'r', 'e', 'e', 'b', 's', 'd' },
        { 'u', 'b', 'u', 'n', 't', 'u' },
        { 'j', 'e', 'e' }
    };*/


    BufferedImage bufferedImage = new BufferedImage(width, height, 
                  BufferedImage.TYPE_INT_RGB);

    Graphics2D g2d = bufferedImage.createGraphics();

    Font font = new Font("Georgia", Font.BOLD, 18);
    g2d.setFont(font);

    RenderingHints rh = new RenderingHints(
           RenderingHints.KEY_ANTIALIASING,
           RenderingHints.VALUE_ANTIALIAS_ON);

    rh.put(RenderingHints.KEY_RENDERING, 
           RenderingHints.VALUE_RENDER_QUALITY);

    g2d.setRenderingHints(rh);

    GradientPaint gp = new GradientPaint(0, 0, 
    Color.blue, 0, height/2, Color.red, true);

    g2d.setPaint(gp);
    g2d.fillRect(0, 0, width, height);

    g2d.setColor(new Color(255, 153, 0));

    Random r = new Random();
    int index = Math.abs(r.nextInt()) % 5;
    int diff= Math.abs(r.nextInt()) % 10;
    if (diff<5)
    	diff+=5;
    String captcha="";
    for (;index<data.length;index+=diff)
    {
    	captcha+=data[index];
    }
    //String captcha = String.copyValueOf(data[index]);
    request.getSession().setAttribute("captcha", captcha );

    int x = 0; 
    int y = 0;

    for (int i=0; i<captcha.length(); i++) {
        x += 10 + (Math.abs(r.nextInt()) % 15);
        y = 20 + Math.abs(r.nextInt()) % 20;
        g2d.drawChars(captcha.toCharArray(), i, 1, x, y);
    }

    g2d.dispose();
    response.setContentType("image/png");
    OutputStream os = response.getOutputStream();
    ImageIO.write(bufferedImage, "png", os);
    os.close();
  } 
}