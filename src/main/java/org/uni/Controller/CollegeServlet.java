package org.uni.Controller;

import org.uni.domain.College;
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

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CollegeService collegeService = new CollegeServiceImpl();
        College college = new College(request.getParameter("collegeId"), (String) request.getParameter("collegeName"));
        request.setAttribute("isAddCollege", collegeService.add(college));

        request.getRequestDispatcher("/colleges.jsp").forward(request, response);

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        CollegeService collegeService = new CollegeServiceImpl();

        /**
         * 对不起 这段代码可读性基本为0
         * 但是 Basically,这句代码删除了college并将删除结果boolean存入request域
         */
        request.setAttribute("isRemoveCollege", collegeService.removeById(Integer.valueOf(request.getParameter("collegeId"))));

    }
}
