package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.uni.domain.Major;
import org.uni.service.MajorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/majorServlet/*")
public class MajorServlet extends baseServlet {

    @Autowired
    private MajorService majorService;

    public void getAll(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("majors", majorService.list());
    }

    public void add(HttpServletRequest request, HttpServletResponse response) {

//        String majorName, Integer collegeId
        String collegeId = request.getParameter("collegeId");
        String majorName = request.getParameter("majorName");
        boolean b = collegeId != "" ? majorService.save(new Major(majorName, Integer.valueOf(collegeId))) : majorService.save(new Major(majorName));

    }

    public void delete(HttpServletRequest request, HttpServletResponse response) {
        majorService.removeById(Integer.valueOf(request.getParameter("majorId")));
    }

}
