package com.lhl.hotelmanager.controller;

import com.lhl.hotelmanager.entity.Menu;
import com.lhl.hotelmanager.entity.Room;
import com.lhl.hotelmanager.entity.User;
import com.lhl.hotelmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: hotel-manager
 * @Date: 2018/11/6 0006 下午 7:10
 * @Author: <.*)#)))<
 * @Description:用户、菜单、权限管理
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    UserService userService;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public User Login(@RequestBody User user) {
        User loginUser = userService.login(user);//= new User();
        /*if(loginUser!=null){
            request.getSession().setAttribute("loginUser",loginUser);
        }*/

        return loginUser;
    }

    @PostMapping(value = "/getMenu", produces = "application/json;charset=UTF-8")
    public List<Menu> getMenu() {
        List<Menu> menus = userService.getMenu();
        return menus;
    }

    @PostMapping(value = "/getRoom", produces = "application/json;charset=UTF-8")
    public Room Login() {
        Room room = new Room();

        return room;
    }

}
