package org.uni.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/stu/*")
public class stuDispatcher extends baseServlet {
    public void test(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        System.out.println("name..." + name);
        System.out.println("test...");
    }
}
