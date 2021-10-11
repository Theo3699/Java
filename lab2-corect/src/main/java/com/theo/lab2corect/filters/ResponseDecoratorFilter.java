package com.theo.lab2corect.filters;

import com.theo.lab2corect.wrappers.SimpleResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = {"/repository", "/"})
public class ResponseDecoratorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SimpleResponseWrapper wrapper = new SimpleResponseWrapper((HttpServletResponse) response);
        //Send the decorated object as a replacement for the original response
        chain.doFilter(request, wrapper);
        //Get the dynamically generated content from the decorator
        String content = wrapper.toString();
        // Modify the content
        String prelude = "<prelude>" +
                "  <h1>Content added by ResponseDecoratorFilter at the beginning of the HTML page</h1>" +
                "  <p>Java second laboratory</p>" +
                "</prelude>";
        String coda = "<footer>" +
                "  <p>Author: Samson Theodor<br>" +
                "  <a href=\"mailto:theodor.samson@info.uaic.ro\">theodor.samson@info.uaic.ro</a></p>" +
                "</footer>";
        String preludePlusContentPlusCoda = prelude + content + coda;
        //Send the modified content using the original response
        PrintWriter out = response.getWriter();
        out.write(preludePlusContentPlusCoda);
    }
}