package org.uni.Controller;

import org.springframework.web.bind.annotation.*;
import org.uni.dto.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/loginInfo")
public class UserController {

    @GetMapping("/role")
    public Result getRole(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("ROLE");
        return role == null ? new Result(false, "没有登录") : new Result(role);
    }

    @GetMapping("/roleInfo")
    public Result getRoleInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object roleinfo =  session.getAttribute("ROLEINFO");
        /**
         * ROLEINFO 有可能是学生或者教师对象
         */
        return roleinfo == null ? new Result(false, "没有登录") : new Result(roleinfo);
    }

    @PutMapping("/logout")
    public Result logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("ROLE");
        session.removeAttribute("ROLEINFO");

        return new Result(true);
    }
}
