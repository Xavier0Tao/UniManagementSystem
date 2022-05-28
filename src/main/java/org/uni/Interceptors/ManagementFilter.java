package org.uni.Interceptors;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "AccessibilityFilter",urlPatterns = "/*")
public class ManagementFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //===============获取Response对象=============
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        //=============强转..获取session域对象==============
        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpSession session = httprequest.getSession();

        //=================获取请求路径==============
        String requestURI = httprequest.getRequestURI().substring(1);

        Logger logger = Logger.getLogger(ManagementFilter.class.getName());
        logger.info("请求路径为：" + requestURI);

        //==============从session中获取登录信息============
        String role = (String) session.getAttribute("ROLE");

        //===========检查访问以下资源时 ，是否登录如果未登录直接打回=========
        if ("class-managment.jsp".equals(requestURI) ||
                "college-managment.jsp".equals(requestURI) ||
                "major-management.jsp".equals(requestURI) ||
                "student-managment.jsp".equals(requestURI)) {
            if (role == null) {
                //未登录，拦截
                logger.warning("未登录，无法访问...");

                //跳转到登录页面
                request.getRequestDispatcher("/pages-login.html").forward(request, response);
                return;
            } else if (role.charAt(0) != 'T') {
                //无权限，拦截
                logger.warning("无权限，无法访问...");

                //跳转到 无权限error page
                ((HttpServletResponse) response).sendRedirect("/pages-error-404.html");
                return;
            }
        }

        //==============检查是否有系统管理员权限===============
        if ("stuServlet/delete".equals(requestURI) ||
                "stuServlet/add".equals(requestURI) ||
                "classServlet/delete".equals(requestURI) ||
                "classServlet/add".equals(requestURI) ||
                "collegeServlet/delete".equals(requestURI) ||
                "collegeServlet/add".equals(requestURI) ||
                "majorServlet/delete".equals(requestURI) ||
                "majorServlet/add".equals(requestURI)) {
            if (!"T_系统管理员".equals(role)) {
                //没有访问权限，跳转到无权限页面
                logger.warning("无权限，无法访问...");

                //跳转到 无权限error page
                ((HttpServletResponse) response).sendRedirect("/pages-error-404.html");

                //跳转到 无权限error page
//                request.getRequestDispatcher("/pages-error-404.html").forward(request, response);
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
