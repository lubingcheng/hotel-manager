package com.lhl.hotelmanager.serviceImpl;

import com.lhl.hotelmanager.dao.UserDao;
import com.lhl.hotelmanager.entity.Menu;
import com.lhl.hotelmanager.entity.Room;
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

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<Room> getAllRoom() {
        return userDao.getAllRoom();
    }

    @Override
    public int insertRoom(Room room) {
        return userDao.insertRoom(room);
    }

    @Override
    public int deleteRoom(int id) {
        return userDao.deleteRoom(id);
    }

    @Override
    public int updateRoom(Room room) {
        return userDao.updateRoom(room);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
