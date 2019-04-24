package com.java.config;

import com.java.entity.user.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author 倪军
 * @version 0.1
 * @time 2017/3/14 11:29
 */
public class Interceptor implements HandlerInterceptor {
    /**
     * 在处理请求之前被调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        //获得登录对象
        User model = (User) request.getSession().getAttribute("LoginMoldel");
        //获得请求的url
        String url = request.getServletPath();
        //登录请求不拦截
        if ("/views/login.html".equals(url) || url.startsWith("/menu")) {
            return true;
        }

        if (("/user").equals(url) || url.startsWith("/views")) {
            if (model != null && !model.equals("")) {//如果登录对象存在
               return true;
            } else {
                //response.sendRedirect(request.getContextPath() + "/login.html");
                String loginUrl = request.getContextPath() + "/views/login.html";
                String str = "<script language='javascript'>alert('会话已过期，请重新登录');"
                        + "window.top.location.href='" + loginUrl + "';</script>";
                response.setContentType("text/html;charset=UTF-8");// 解决中文乱码
                try {
                    PrintWriter writer = response.getWriter();
                    writer.write(str);
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println();
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
