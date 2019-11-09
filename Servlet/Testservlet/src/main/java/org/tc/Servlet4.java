package org.tc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
        System.out.println("I am servlet4");
        String love = (String) this.getServletContext().getAttribute("love");
        System.out.println(love);
        resp.setContentType("text/html;charset=utf-8");
        //向页面输出内容
        PrintWriter out = resp.getWriter();
        out.println("servlet4 got: "+love);
        System.out.println("servlet4 has got");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet4: dopost");
    }
}
