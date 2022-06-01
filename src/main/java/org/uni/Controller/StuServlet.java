package org.uni.Controller;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.uni.domain.Students;
import org.uni.service.impl.StudentsServiceImpl;

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
        String sex = request.getParameter("sex");
        String sname = request.getParameter("sname");

        Integer collid = StringUtils.isEmpty(request.getParameter("collid")) ? null : Integer.valueOf(request.getParameter("collid"));
        Integer mno = StringUtils.isEmpty(request.getParameter("mno")) ? null : Integer.valueOf(request.getParameter("mno"));
        String city = request.getParameter("city");
        String identity = request.getParameter("identity");

        if (!StringUtils.isEmpty(identity)) student.setId(identity);
        if (!StringUtils.isEmpty(sex)) student.setSex(sex);
        if (!StringUtils.isEmpty(sname)) student.setSname(sname);
        if (collid != null) student.setCollid(collid);
        if (mno != null) student.setMno(mno);
        if (!StringUtils.isEmpty(city)) student.setSori(city);

        stuService.save(student);
    }

}
