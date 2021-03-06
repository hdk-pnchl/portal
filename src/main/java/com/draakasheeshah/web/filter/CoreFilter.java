package com.draakasheeshah.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CoreFilter
    implements Filter
{

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws IOException,
            ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        System.out.println("FILTER:::::   " + httpRequest.getRequestURI());
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0)
        throws ServletException
    {
    }
}
