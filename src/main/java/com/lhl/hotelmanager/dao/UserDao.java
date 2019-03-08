package com.lhl.hotelmanager.dao;

import com.lhl.hotelmanager.entity.Menu;
import com.lhl.hotelmanager.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: hotel-manager
 * @Date: 2018/11/6 0006 下午 8:03
 * @Author: <.*)#)))<
 * @Description:
 */
@Mapper
public interface UserDao {

    User login(User user);

    List<Menu> getMenu();
}
