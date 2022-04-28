package org.uni.Controller;

import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class baseServlet extends HttpServlet {

    public void init() throws ServletException {
        super.init();
        WebApplicationContextUtils
                .getWebApplicationContext(getServletContext())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }

    /**
     * 根据请求URL的后半段地址分发 方法
     * 类似SpringMVC对http请求的分发RequestMapping
     *
     * @param req
     * @param resp
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //1.获取请求路径
        String requestURI = req.getRequestURI();

        System.out.println("请求路径URI..." + requestURI);

        //从请求路径中解析出方法名
        //从请求路径中解析出方法名
        int index = requestURI.lastIndexOf('/');
        String methodname = requestURI.substring(index + 1);

        System.out.println(methodname);

        //2. 执行方法
        System.out.println(this);

        //2.1 获取**实体servlet**的字节码文件即class文件
        Class<? extends baseServlet> servletClass = this.getClass();

        try {
            //获取方法
            Method method = servletClass.getMethod(methodname, HttpServletRequest.class, HttpServletResponse.class);

            //调用方法(传的是参数） 上面的method定义里写的是什么 这里的参数就传什么
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
