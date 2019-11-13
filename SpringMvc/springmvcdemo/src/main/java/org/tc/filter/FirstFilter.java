package org.tc.filter;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //在DispatcherServlet之前执行
        System.out.println("############FirstFilter doFilterInternal executed############");
        filterChain.doFilter(request, response);
        //在视图页面返回给客户端之前执行，但是执行顺序在Interceptor之后
        System.out.println("############FirstFilter doFilter after############");
    }

    @Override
    public void destroy() {

    }


}
