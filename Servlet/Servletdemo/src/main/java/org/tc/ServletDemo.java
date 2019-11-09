package org.tc;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servlet")
public class ServletDemo extends GenericServlet {


    @Override
    public void service(ServletRequest servletRequest, ServletResponse resp) throws ServletException, IOException {
        System.out.println("I am servlet");
        resp.setContentType("text/html;charset=utf-8");
        //向页面输出内容
        PrintWriter out = resp.getWriter();
        out.println("<h1>I am servlet</h1>");
    }
}
