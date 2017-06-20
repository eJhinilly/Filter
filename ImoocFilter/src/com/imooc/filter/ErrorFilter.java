package com.imooc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by localhost on 17-6-19.
 */

public class ErrorFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("检测到有错误信息");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
