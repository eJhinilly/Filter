package com.imooc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by localhost on 17-6-19.
 */
public class SecondFilter implements Filter {
    public void destroy() {
        System.out.println("destroy-----SecondFilter");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Start-----doFilter----SecondFilter");
        chain.doFilter(req, resp);
        System.out.println("End-----doFilter----SecondFilter");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init-----SecondFilter");
    }

}
