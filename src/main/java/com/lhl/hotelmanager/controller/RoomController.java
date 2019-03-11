package com.lhl.hotelmanager.controller;

import com.lhl.hotelmanager.entity.InRoom;
import com.lhl.hotelmanager.entity.OutRoom;
import com.lhl.hotelmanager.entity.Reservation;
import com.lhl.hotelmanager.entity.RoomStatus;
import com.lhl.hotelmanager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: hotel-manager
 * @Date: 2019/3/8 0008 下午 2:47
 * @Author: <.*)#)))<
 * @Description:
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping(value = "/getAllRoomTree")
    public List getAllRoomTree() {
        List result = roomService.getAllRoomTree();
        return result;
    }

    @PostMapping(value = "/getAllRoom")
    public List getAllRoom() {
        List result = roomService.getAllRoom();
        return result;
    }

    @PostMapping(value = "/getAllRoomByStatus", produces = "application/json;charset=UTF-8")
    public List getAllRoomByStatus(@RequestBody Map<String, String> params) {
        int status = Integer.parseInt(params.get("status"));
        List result = roomService.getAllRoomByStatus(status);
        return result;
    }

    @PostMapping(value = "/insertReservation", produces = "application/json;charset=UTF-8")
    public Object insertReservation(@RequestBody Reservation reservation) {
        RoomStatus room = roomService.selectRoomStatusByCode(reservation.getRoomCode());
        if (room.getStatus() == 0) {
            int result = roomService.insertReservation(reservation);
            roomService.updateRoomStatus(reservation.getRoomCode(), 1, reservation.getId());
            if (result > 0) {
                return reservation;
            }
        }
        return "error";
    }

    @PostMapping(value = "/insertInRoom", produces = "application/json;charset=UTF-8")
    public Object insertInRoom(@RequestBody InRoom inRoom) {
        RoomStatus room = roomService.selectRoomStatusByCode(inRoom.getRoomCode());
        if (room.getStatus() == 0 || room.getStatus() == 1) {
            int result = roomService.insertInRoom(inRoom);
            roomService.updateRoomStatus(inRoom.getRoomCode(), 2, inRoom.getId());
            if (room.getStatus() == 1) {
                roomService.updateReservationStatus(room.getOrderCode());
            }
            if (result > 0) {
                return inRoom;
            }
        }
        return "error";
    }

    @PostMapping(value = "/getReservationById", produces = "application/json;charset=UTF-8")
    public Object getReservationById(@RequestBody Map<String, String> params) {
        int id = Integer.parseInt(params.get("id"));
        Reservation result = roomService.getReservationById(id);
        return result;
    }

    @PostMapping(value = "/getAllReservation")
    public Object getAllReservation() {
        List<Reservation> reservations = roomService.getAllReservation();
        return reservations;
    }

    /**
     * 离店管理
     *
     * @param inRoom
     * @return
     */
    @PostMapping(value = "/insertOutRoom", produces = "application/json;charset=UTF-8")
    public Object insertOutRoom(@RequestBody OutRoom outRoom) {
        RoomStatus room = roomService.selectRoomStatusByCode(outRoom.getRoomCode());
        if (room.getStatus() == 2) {
            int result = roomService.insertOutRoom(outRoom);
            roomService.updateRoomStatus(outRoom.getRoomCode(), 0, outRoom.getId());
            roomService.updateInRoomStatus(room.getOrderCode());
            if (result > 0) {
                return outRoom;
            }
        }
        return "error";
    }


    @PostMapping(value = "/getInRoomById", produces = "application/json;charset=UTF-8")
    public Object getInRoomById(@RequestBody Map<String, String> params) {
        int id = Integer.parseInt(params.get("id"));
        InRoom result = roomService.getInRoomById(id);
        return result;
    }
}
