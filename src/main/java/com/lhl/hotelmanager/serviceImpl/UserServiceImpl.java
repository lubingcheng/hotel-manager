package com.lhl.hotelmanager.serviceImpl;

import com.lhl.hotelmanager.dao.UserDao;
import com.lhl.hotelmanager.entity.Menu;
import com.lhl.hotelmanager.entity.User;
import com.lhl.hotelmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: hotel-manager
 * @Date: 2018/11/6 0006 下午 8:18
 * @Author: <.*)#)))<
 * @Description:
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;


    public User login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<Menu> getMenu() {
        return userDao.getMenu();
    }
}
