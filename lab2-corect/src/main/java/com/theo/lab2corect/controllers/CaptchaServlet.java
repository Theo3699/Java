package com.theo.lab2corect.controllers;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CaptchaServlet", urlPatterns = "/captcha")
public class CaptchaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String captchaString = generateCaptchaString();
        System.out.println(captchaString);

        request.setAttribute("captchaString", captchaString);

        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Bradley Hand ITC", Font.ITALIC, 48);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(captchaString);
        int height = fm.getHeight();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2d.setColor(Color.yellow);
        g2d.drawString(captchaString, 0, fm.getAscent());
        g2d.setColor(Color.RED);
// creates a solid stroke with line width is 2
        Stroke stroke = new BasicStroke(2f);
        g2d.setStroke(stroke);
        g2d.drawLine(0, 25, 360, 50);
        g2d.dispose();

        response.setContentType("image/jpg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        ImageIO.write(img, "jpg", responseOutputStream);
        responseOutputStream.close();
    }

    /**
     *  Generate a CAPTCHA String consisting of random lowercase & uppercase letters, and numbers.
     */
    public String generateCaptchaString() {
        Random random = new Random();
        int length = 7 + (Math.abs(random.nextInt()) % 3);

        StringBuffer captchaStringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int baseCharNumber = Math.abs(random.nextInt()) % 62;
            int charNumber = 0;
            if (baseCharNumber < 26) {
                charNumber = 65 + baseCharNumber;
            }
            else if (baseCharNumber < 52){
                charNumber = 97 + (baseCharNumber - 26);
            }
            else {
                charNumber = 48 + (baseCharNumber - 52);
            }
            captchaStringBuffer.append((char)charNumber);
        }

        return captchaStringBuffer.toString();
    }
}
