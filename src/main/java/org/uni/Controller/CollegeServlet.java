package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.uni.dao.CollegeMapper;
import org.uni.domain.College;
import org.uni.service.CollegeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/collegeServlet/*")
public class CollegeServlet extends baseServlet {

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private CollegeMapper collegeDao;

    /**
     * 获取所有学院
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        ApplicationContext context = applicationContext.context;
        this.collegeDao = (CollegeMapper) context.getBean("collegeDao");*/

        HttpSession session = request.getSession();
        session.setAttribute("colleges", collegeDao.selectList(null));
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        College college = new College((String) request.getParameter("collegeName"));

        HttpSession session = request.getSession();

        session.setAttribute("isAddCollege", collegeService.add(college));
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        session.setAttribute("isRemoveCollege", collegeService.removeById(Integer.valueOf(request.getParameter("collegeId"))));

    }
}
