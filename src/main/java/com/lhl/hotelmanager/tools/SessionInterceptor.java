package com.lhl.hotelmanager.tools;

import com.lhl.hotelmanager.tools.exception.ErroMessage;
import com.lhl.hotelmanager.tools.exception.LogicException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: hotel-manager
 * @Date: 2018/11/12 0012 下午 3:53
 * @Author: <.*)#)))<
 * @Description:
 */
//登陆验证拦截器
@Component
public class SessionInterceptor implements HandlerInterceptor {


    //登陆验证拦截器，拦截系统所有请求
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //判断当前访问方法是否是登陆方法
        if (request.getRequestURI().equals("/user/login")) {
            //访问登陆方法  不拦截  放行
            return true;
        }
        //不是登陆方法  尝试从Session中获取登陆用户信息
        Object object = request.getSession().getAttribute("loginUser");
        if (object == null) {
            // 获取到用户信息 为空，表示没有登陆 拦截本次请求，并抛出未登录异常
            throw LogicException.leException(ErroMessage.NOT_LOGIN);
        }
        //用户信息不为空  表示已登陆  放行
        return true;
    }


}
