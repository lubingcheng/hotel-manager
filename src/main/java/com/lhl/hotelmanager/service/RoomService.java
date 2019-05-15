package com.lhl.hotelmanager.service;

import com.lhl.hotelmanager.entity.*;

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

    int updateReservation(Reservation reservation);

    int insertInRoom(InRoom inRoom);

    int updateRoomStatus(int id, int status, int orderCode);

    int updateReservationStatus(int id);

    RoomStatus selectRoomStatusByCode(int code);

    Reservation getReservationById(int id);

    List<Reservation> getTodayReservation();

    List<Reservation> getAllReservation();

    List<InRoom> getAllInRoom();

    List<OutRoom> getAllOutRoom();

    InRoom getInRoomById(int id);

    int insertOutRoom(OutRoom outRoom);

    int updateInRoomStatus(int id);

    int changeRoom(InRoom inRoom);

}
