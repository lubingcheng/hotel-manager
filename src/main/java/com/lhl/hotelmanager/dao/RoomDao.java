package com.lhl.hotelmanager.dao;

import com.lhl.hotelmanager.entity.Room;
import com.lhl.hotelmanager.entity.RoomAll;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: hotel-manager
 * @Date: 2018/11/6 0006 下午 8:03
 * @Author: <.*)#)))<
 * @Description:
 */
@Mapper
public interface RoomDao {

    List<RoomAll> getAllRoom();

    List<Room> getAllFloor();
}
