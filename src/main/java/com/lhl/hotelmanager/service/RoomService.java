package com.lhl.hotelmanager.service;

import com.lhl.hotelmanager.entity.InRoom;
import com.lhl.hotelmanager.entity.Reservation;
import com.lhl.hotelmanager.entity.Room;
import com.lhl.hotelmanager.entity.RoomStatus;

import java.util.List;

/**
 * @program: hotel-manager
 * @Date: 2018/11/6 0006 下午 8:17
 * @Author: <.*)#)))<
 * @Description:
 */
public interface RoomService {

    List<Room> getAllRoom();

    List<Room> getAllRoomTree();

    List<Room> getAllRoomByStatus(int status);

    int insertReservation(Reservation reservation);

    int insertInRoom(InRoom inRoom);

    int updateRoomStatus(int id, int status, int orderCode);

    int updateReservationStatus(int id);

    RoomStatus selectRoomStatusByCode(int code);

    Reservation getReservationById(int id);

    List<Reservation> getAllReservation();

}
