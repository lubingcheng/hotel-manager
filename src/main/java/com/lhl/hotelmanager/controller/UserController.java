package com.lhl.hotelmanager.controller;

import com.lhl.hotelmanager.entity.Menu;
import com.lhl.hotelmanager.entity.Room;
import com.lhl.hotelmanager.entity.User;
import com.lhl.hotelmanager.service.UserService;
import com.lhl.hotelmanager.tools.exception.ErroMessage;
import com.lhl.hotelmanager.tools.exception.LogicException;
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
        //验证用户名 密码是否正确 ，正确：存储用户信息。不正确：不做任何处理。
        User loginUser = userService.login(user);//= new User();
        if (loginUser != null) {
            //存储用户信息至Session，作为验证是否登陆依据。
            request.getSession().setAttribute("loginUser",loginUser);
        }
        //返回数据库对应结果对象。
        return loginUser;
    }

    @PostMapping(value = "/logOut", produces = "application/json;charset=UTF-8")
    public Object logOut() {
        Object loginUser =  request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            request.getSession().setAttribute("loginUser",null);
        }
        throw LogicException.leException(ErroMessage.NOT_LOGIN);
    }

    @PostMapping(value = "/getMenu", produces = "application/json;charset=UTF-8")
    public List<Menu> getMenu() {
        List<Menu> menus = userService.getMenu();
        return menus;
    }

    @PostMapping(value = "/getAllRoom", produces = "application/json;charset=UTF-8")
    public List<Room> getAllRoom() {
        return userService.getAllRoom();
    }

    @PostMapping(value = "/getAllUser", produces = "application/json;charset=UTF-8")
    public List<User> getAllUser() {
        //获取数据库 所有用户信息
        return userService.getAllUser();
    }

    @PostMapping(value = "/insertRoom", produces = "application/json;charset=UTF-8")
    public Object insertRoom(@RequestBody Room room) {
        return userService.insertRoom(room);
    }

    @PostMapping(value = "/insertUser", produces = "application/json;charset=UTF-8")
    public Object insertUser(@RequestBody User user) {
        //将用户信息 新增至数据库
        return userService.insertUser(user);
    }

    @PostMapping(value = "/deleteRoom", produces = "application/json;charset=UTF-8")
    public Object deleteRoom(@RequestBody Room room) {
        return userService.deleteRoom(room.getId());
    }

    @PostMapping(value = "/deleteUser", produces = "application/json;charset=UTF-8")
    public Object deleteUser(@RequestBody User user) {
        //删除用户信息
        return userService.deleteUser(user.getId());
    }


    @PostMapping(value = "/updateRoom", produces = "application/json;charset=UTF-8")
    public Object updateRoom(@RequestBody Room room) {
        return userService.updateRoom(room);
    }

    @PostMapping(value = "/updateUser", produces = "application/json;charset=UTF-8")
    public Object updateUser(@RequestBody User user) {
        //修改用户信息
        return userService.updateUser(user);
    }

}
