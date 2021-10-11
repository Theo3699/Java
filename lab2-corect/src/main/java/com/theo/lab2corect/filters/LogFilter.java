package com.theo.lab2corect.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/repository", "/"})
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        // Find the IP of the request
        String ipAddress = request.getRemoteAddr();
        // Write something in the log
        System.out.println(String.format("\nMethod used: %s\n\"Client ip: %s\nUser Agent: %s",
                request.getMethod(),
                request.getRemoteAddr(),
                request.getHeader("User-Agent")));

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}