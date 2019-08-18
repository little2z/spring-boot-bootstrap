package com.xyl.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest  request = (HttpServletRequest)servletRequest;

        log.info("Starting a request for req: {}", request.getRequestURI());


        filterChain.doFilter(servletRequest, servletResponse);


        log.info("Committing a transaction for req : {}", request.getRequestURI());

    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }
}
