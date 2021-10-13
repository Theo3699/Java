package com.theo.lab2corect.controllers;

import com.theo.lab2corect.DTOs.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CaptchaValidatorServlet", urlPatterns = "/validator")
public class CaptchaValidator extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String inputCaptchaString = request.getParameter("captchaString");
        String generatedCaptchaString = (String) request.getSession().getAttribute("captchaString");
        if (inputCaptchaString.equals(generatedCaptchaString)) {
            getServletContext().getRequestDispatcher("/repository").forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/first").forward(request, response);
        }
    }
}
