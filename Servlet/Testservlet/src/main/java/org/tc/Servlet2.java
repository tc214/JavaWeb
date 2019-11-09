package org.tc;

import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {




    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("I am servlet2");
        ServletContext application = this.getServletContext();
        application.setAttribute("name","from servlet2");
        application.getRequestDispatcher("/servlet3").forward(req,res);
    }




}
