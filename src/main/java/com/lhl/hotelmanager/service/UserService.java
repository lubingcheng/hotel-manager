package com.lhl.hotelmanager.service;

import com.lhl.hotelmanager.entity.Menu;
import com.lhl.hotelmanager.entity.Room;
import com.lhl.hotelmanager.entity.User;

import java.util.List;

/**
 * @program: hotel-manager
 * @Date: 2018/11/6 0006 下午 8:17
 * @Author: <.*)#)))<
 * @Description:
 */
public interface UserService {

    User login(User user);

    List<Menu> getMenu();

    List<User> getAllUser();

    int insertUser(User user);

    int deleteUser(int id);

    List<Room> getAllRoom();

    int insertRoom(Room room);

    int deleteRoom(int id);

    int updateRoom(Room room);

    int updateUser(User user);

}
