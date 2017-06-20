package com.imooc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by localhost on 17-6-20.
 */
public class LoginFilter implements Filter {

    private FilterConfig config;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session= request.getSession();
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding(config.getInitParameter("charset"));

        String noLoginPaths = config.getInitParameter("noLoginPaths");

        if(noLoginPaths!=null){
            String[] StrArray = noLoginPaths.split(";");
            for (String Str:
                 StrArray) {
                    if(Str==null || "".equals(Str))continue;
                    if(request.getRequestURI().indexOf(Str)!=-1  ){
                        chain.doFilter(req, resp);
                        return;
                    }
            }
        }



        //如果没有登录，不能访问success.jsp
        if(session.getAttribute("username")!=null) {
            chain.doFilter(req, resp);
        }
        else {
            response.sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
