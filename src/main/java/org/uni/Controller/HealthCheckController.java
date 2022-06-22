package org.uni.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uni.domain.StuCheck;
import org.uni.domain.Students;
import org.uni.domain.TeaCheck;
import org.uni.domain.Teachers;
import org.uni.service.StuCheckService;
import org.uni.service.TeaCheckService;
import org.uni.dto.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/healthcheck")
public class HealthCheckController {

    @Autowired
    private StuCheckService stuCheckService;

    @Autowired
    private TeaCheckService teaCheckService;

    /**
     * 通过身份证打卡
     * @param request
     * @return
     * @throws ClassNotFoundException
     */
    @PostMapping("/identity")
    public Result check(HttpServletRequest request) throws ClassNotFoundException {
        Result result = new Result();

        HttpSession session = request.getSession();
        /**
         * 尝试反射 --> 失败...太麻烦了
         */
/*        String role = (String) session.getAttribute("ROLE");
        role = role == "STU" ? "Stu" + "CheckService" : "TeachersService";

        String daoName = role == "STU" ? "StudentsMapper" : "TeachersMapper";

        Class<?> checkService = Class.forName(role);

        Class<?> dao = Class.forName(daoName);

        dao.getMethod("")*/

        String role = (String) session.getAttribute("ROLE");

        //是否是学生？
        if (role == "STU") {
            Students stuInfo = (Students) session.getAttribute("ROLEINFO");
            Integer sno = stuInfo.getSno();
            StuCheck stuCheck = new StuCheck(sno);

            result.setCode(stuCheckService.save(stuCheck) == true ? 1 : 0);
            return result;
        }
        //是否是老师？
        else if(role.charAt(0)=='T'){
            Teachers roleinfo = (Teachers) session.getAttribute("ROLEINFO");
            Integer teacherId = roleinfo.getTeacherId();
            TeaCheck teaCheck = new TeaCheck(teacherId);

            result.setCode(teaCheckService.save(teaCheck) == true ? 1 : 0);
            return result;
        }else {
            return new Result(false, "出错啦");
        }

    }
}
