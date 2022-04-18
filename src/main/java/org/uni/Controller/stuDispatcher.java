package org.uni.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stu/*")
public class stuDispatcher extends baseServlet {
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("test...servlet get request from base servlet");

        response.setContentType("application/json");

        response.getWriter().write("response content ...");
    }
}
