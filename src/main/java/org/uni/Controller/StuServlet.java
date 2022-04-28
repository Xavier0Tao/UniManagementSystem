package org.uni.Controller;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.uni.domain.Students;
import org.uni.service.impl.StudentsServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/stuServlet/*")
public class StuServlet extends baseServlet {

    @Autowired
    private StudentsServiceImpl stuService;


    public void getAll(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.setAttribute("students", stuService.list());

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        /**
         * 需要前端传 stuId 来删除学生
         */
        stuService.removeById(Integer.valueOf(request.getParameter("stuId")));
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Students student = new Students();
        student.setSex(request.getParameter("sex"));
        student.setSname(request.getParameter("sname"));
        student.setCollid(Integer.valueOf(request.getParameter("collid")));
        student.setSage(Integer.valueOf(request.getParameter("mno")));
        student.setSori(request.getParameter("city"));

        stuService.save(student);
    }

}
