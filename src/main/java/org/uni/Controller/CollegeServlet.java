package org.uni.Controller;

import org.uni.service.CollegeService;
import org.uni.service.impl.CollegeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/collegeServlet")
public class CollegeServlet extends baseServlet {

    public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CollegeService collegeService = new CollegeServiceImpl();
        request.setAttribute("colleges", collegeService.list());

        request.getRequestDispatcher("/colleges.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {

    }

}
