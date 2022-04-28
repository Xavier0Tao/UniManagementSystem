package org.uni.Interceptors;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        Logger logger = Logger.getLogger(LoginFilter.class.getName());
        logger.info("LoginFilter....init");
        chain.doFilter(request, response);
    }
}
