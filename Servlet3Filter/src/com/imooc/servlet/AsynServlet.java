package com.imooc.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by localhost on 17-6-19.
 */
public class AsynServlet extends HttpServlet {

    public AsynServlet(){
        super();
    }

    public void destroy(){
        super.destroy();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Servlet执行开始时间:"+new Date());
        AsyncContext context =  request.startAsync();
        new Thread(new Executor(context)).start();
        System.out.println("Servlet执行结束时间:"+new Date());
    }

    public class Executor implements Runnable{
        private AsyncContext context;
        public Executor(AsyncContext context ) {
            this.context = context;
        }

        @Override
        public void run() {
            //执行相关复杂业务
            try {
                Thread.sleep(1000*10);
//				context.getRequest();
//				context.getResponse();
                System.out.println("业务执行完成时间:"+new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
