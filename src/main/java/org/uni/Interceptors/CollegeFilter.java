package org.uni.Interceptors;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CollegeFilter",urlPatterns = "/collegeServlet/*")
public class CollegeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        chain.doFilter(request, response);

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        httpServletResponse.setStatus(301);
        httpServletResponse.setHeader("location", "/college-managment.jsp");
    }
}
