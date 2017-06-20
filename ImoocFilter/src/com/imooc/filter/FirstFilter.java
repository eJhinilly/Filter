package com.imooc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by localhost on 17-6-19.
 */

public class FirstFilter implements Filter {
    public void destroy() {
        System.out.println("destroy-----FirstFilter");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Start ..... doFilter-----FirstFilter");
//        chain.doFilter(req, resp);

        HttpServletRequest req2 = (HttpServletRequest) req;
        HttpServletResponse resp2 = (HttpServletResponse) resp;
        //重定向
        resp2.sendRedirect(req2.getContextPath()+"/main.jsp");
        //转发
//        req2.getRequestDispatcher("main.jsp").forward(req,resp);
//        req2.getRequestDispatcher("main.jsp").include(req,resp);
        System.out.println("End ..... doFilter-----FirstFilter");
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("init-----FirstFilter");
    }

}
