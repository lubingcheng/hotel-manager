package com.lhl.hotelmanager.dao;

import com.lhl.hotelmanager.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    List<Room> getAllRoomByStatus(int status);

    List<Room> getAllRoomWithOutStatus(int status);

    int insertReservation(Reservation reservation);

    int insertInRoom(InRoom inRoom);

    int updateRoomStatus(@Param("code") int code, @Param("status") int status, @Param("orderCode") int orderCode);

    RoomStatus selectRoomStatusByCode(int code);

    Reservation getReservationById(int id);

    int updateReservationStatus(int id);

    List<Reservation> getAllReservation();
}
