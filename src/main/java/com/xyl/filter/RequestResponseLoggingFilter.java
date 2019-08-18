package com.xyl.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class RequestResponseLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest  request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        log.info("Logging request {} : {}", request.getMethod(), request.getRequestURI());


        filterChain.doFilter(servletRequest, servletResponse);

        
        log.info("Logging Response : {}", response.getContentType());

    }

    @Override
    public void destroy() {

    }
}
