package com.imooc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by localhost on 17-6-19.
 */
@WebFilter(filterName = "AsynFilter",asyncSupported = true,value = {"/servlet/AsynServlet"},dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.ASYNC} )
public class AsynFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("start.......AsynFilter");
        chain.doFilter(req, resp);
        System.out.println("End.......AsynFilter");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
