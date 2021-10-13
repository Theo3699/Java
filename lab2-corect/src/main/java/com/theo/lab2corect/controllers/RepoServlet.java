package com.theo.lab2corect.controllers;

import com.theo.lab2corect.DTOs.Record;
import com.theo.lab2corect.DTOs.Repository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "repoServlet", value = "/repository")
public class RepoServlet extends HttpServlet {
    Repository repository;

    public void init(){
        repository = new Repository();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String inputCaptchaString = request.getParameter("captchaString");
        String generatedCaptchaString = (String) request.getSession().getAttribute("captchaString");
        if (inputCaptchaString.equals(generatedCaptchaString)) {
            String category = request.getParameter("categorySelect");
            String key = request.getParameter("key");
            String value = request.getParameter("value");
            Record record = new Record(category, key, value);
            repository.addRecord(record);

            Cookie cookie = new Cookie("CategorySelection", category);
            cookie.setMaxAge(120);
            response.addCookie(cookie);
            request.setAttribute("repository", repository);
            getServletContext().getRequestDispatcher("/WEB-INF/pages/result.jsp").forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/pages/wrongCaptcha.jsp").forward(request, response);
        }

    }
}
