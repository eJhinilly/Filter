package com.imooc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by localhost on 17-6-20.
 */

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);

        if("admin".equals(username) && "admin".equals(password)){
            //校验通过
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect("/success.jsp");
        }
        else {//校验失败
            response.sendRedirect("/fail.jsp");

        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
