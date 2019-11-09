package org.tc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
        System.out.println("I am servlet3");
        //设置输出格式和字符编码
        resp.setContentType("text/html;charset=utf-8");
        //向页面输出内容
        PrintWriter out = resp.getWriter();
        out.println("<h1>I am servlet3</h1>");
        ServletContext application = this.getServletContext();
        String name = (String) application.getAttribute("name");
        System.out.println("servlet3 got name: "+name);
        out.println("servlet3 got name："+name);
        System.out.println("servlet3 got it");
        application.setAttribute("love","Liudehua love ylq");
        application.getRequestDispatcher("/servlet4").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("servlet3: dopost");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>I am servlet3</h1>");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("I am servlet3");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>I am servlet3</h1>");
    }
}
