package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.uni.domain.Class;
import org.uni.service.ClassService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/classServlet/*")
public class ClassServlet extends baseServlet {

    @Autowired
    private ClassService classService;

    public void getAll(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("classes", classService.list());
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        Class cls = new Class();
        cls.setMajorNo(Integer.valueOf(request.getParameter("majorId")));

        classService.save(cls);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        classService.removeById(Integer.valueOf(request.getParameter("classNo")));
    }


}
