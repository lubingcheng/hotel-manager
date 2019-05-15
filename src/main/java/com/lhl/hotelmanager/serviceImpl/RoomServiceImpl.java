package com.lhl.hotelmanager.serviceImpl;

import com.lhl.hotelmanager.dao.RoomDao;
import com.lhl.hotelmanager.entity.*;
import com.lhl.hotelmanager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: hotel-manager
 * @Date: 2018/11/6 0006 下午 8:18
 * @Author: <.*)#)))<
 * @Description:
 */
@Service(value = "roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired(required = false)
    RoomDao roomDao;

    @Override
    public List getAllRoomTree() {
        List result = new ArrayList();
        List<Room> floors = roomDao.getAllFloor();
        List<RoomAll> rooms = roomDao.getAllRoom();

        for (Room floor : floors) {
            List<RoomAll> data = new ArrayList<>();
            for (RoomAll room : rooms) {
                if (floor.getFloor() == room.getFloor()) {
                    data.add(room);
                }
            }
            result.add(data);
        }

        return result;
    }

    @Override
    public List<Room> getAllRoomByStatus(int status) {
        if (status == 3) {
            return roomDao.getAllRoomWithOutStatus(2);
        }
        return roomDao.getAllRoomByStatus(status);
    }

    @Override
    public int insertReservation(Reservation reservation) {
        return roomDao.insertReservation(reservation);
    }

    @Override
    public int updateReservation(Reservation reservation) {
        return roomDao.updateReservation(reservation);
    }

    @Override
    public int insertInRoom(InRoom inRoom) {
        return roomDao.insertInRoom(inRoom);
    }

    @Override
    public int updateRoomStatus(int id, int status, int orderCode) {
        return roomDao.updateRoomStatus(id, status, orderCode);
    }

    @Override
    public int updateReservationStatus(int id) {
        return roomDao.updateReservationStatus(id);
    }

    @Override
    public RoomStatus selectRoomStatusByCode(int code) {
        return roomDao.selectRoomStatusByCode(code);
    }

    @Override
    public Reservation getReservationById(int id) {
        return roomDao.getReservationById(id);
    }

    @Override
    public List<Reservation> getTodayReservation() {
        return roomDao.getTodayReservation();
    }

    @Override
    public List<Reservation> getAllReservation() {
        return roomDao.getAllReservation();
    }

    @Override
    public List<InRoom> getAllInRoom() {
        return roomDao.getAllInRoom();
    }

    @Override
    public List<OutRoom> getAllOutRoom() {
        return roomDao.getAllOutRoom();
    }

    @Override
    public InRoom getInRoomById(int id) {
        return roomDao.getInRoomById(id);
    }

    @Override
    public int insertOutRoom(OutRoom outRoom) {
        return roomDao.insertOutRoom(outRoom);
    }

    @Override
    public int updateInRoomStatus(int id) {
        return roomDao.updateInRoomStatus(id);
    }

    @Override
    public int changeRoom(InRoom inRoom) {
        return roomDao.changeRoom(inRoom);
    }

    @Override
    public List getAllRoom() {
        return roomDao.getAllRoom();
    }
}
