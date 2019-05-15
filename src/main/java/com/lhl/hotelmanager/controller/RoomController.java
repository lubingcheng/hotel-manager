package com.lhl.hotelmanager.controller;

import com.lhl.hotelmanager.entity.*;
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

    /**
     * @author:  <.*)#)))<
     * @date: 2019年5月8日 上午 9:02
     * @Description: 获取所有房间信息（以楼层分组，树形结构）
     * @updateUser:
     * @updateDate: 2019年5月8日 上午 9:02
     * @updateDescription:  
     * @param: []
     * @throws: 
     **/
    @PostMapping(value = "/getAllRoomTree")
    public List getAllRoomTree() {
        List result = roomService.getAllRoomTree();
        return result;
    }

    /**
     * @author: <.*)#)))<
     * @date: 2019年5月8日 上午 9:03
     * @Description: 获取所有房间列表
     * @updateUser:
     * @updateDate: 2019年5月8日 上午 9:03
     * @updateDescription:  
     * @param: []
     * @throws: 
     **/
    @PostMapping(value = "/getAllRoom")
    public List getAllRoom() {
        List result = roomService.getAllRoom();
        return result;
    }

    /**
     * @author: <.*)#)))<
     * @date: 2019年5月8日 上午 9:04
     * @Description: 获取当天所有预订信息
     * @updateUser:
     * @updateDate: 2019年5月8日 上午 9:04
     * @updateDescription:  
     * @param: []
     * @throws: 
     **/
    @PostMapping(value = "/getTodayReservation")
    public List getTodayReservation(){
        return roomService.getTodayReservation();
    }

    /**
     * @author:  <.*)#)))<
     * @date: 2019年5月8日 上午 9:04
     * @Description:  通过房间状态  获取匹配的房间信息
     * @updateUser:
     * @updateDate: 2019年5月8日 上午 9:04
     * @updateDescription:  
     * @param: [params 房间状态 空闲、预定、入住]
     * @throws: 
     **/
    @PostMapping(value = "/getAllRoomByStatus", produces = "application/json;charset=UTF-8")
    public List getAllRoomByStatus(@RequestBody Map<String, String> params) {
        int status = Integer.parseInt(params.get("status"));
        List result = roomService.getAllRoomByStatus(status);
        return result;
    }

    /**
     * @author:  <.*)#)))<
     * @date: 2019年5月8日 上午 9:05
     * @Description: 增加预定信息
     * @updateUser:
     * @updateDate: 2019年5月8日 上午 9:05
     * @updateDescription:  
     * @param: [reservation 预定信息对象]
     * @throws: 
     **/
    @PostMapping(value = "/insertReservation", produces = "application/json;charset=UTF-8")
    public Object insertReservation(@RequestBody Reservation reservation) {
        if(reservation.getRoomCode()==0){
            int result = roomService.insertReservation(reservation);
            return reservation;
        }
        else {
            RoomStatus room = roomService.selectRoomStatusByCode(reservation.getRoomCode());
            if (room.getStatus() == 0) {
                int result = 0;
                if(reservation.getId()!=0){
                    result = roomService.updateReservation(reservation);
                }else {
                    result = roomService.insertReservation(reservation);
                }
                roomService.updateRoomStatus(reservation.getRoomCode(), 1, reservation.getId());
                if (result > 0) {
                    return reservation;
                }
            }
        }
        return "error";
    }



    /**
     * 办理入住
     * @param inRoom
     * @return
     */
    @PostMapping(value = "/insertInRoom", produces = "application/json;charset=UTF-8")
    public Object insertInRoom(@RequestBody InRoom inRoom) {
        //获取当前需要操作的房间信息
        RoomStatus room = roomService.selectRoomStatusByCode(inRoom.getRoomCode());
        //验证房间状态是否可以 进行本次操作
        if (room.getStatus() == 0 || room.getStatus() == 1) {
            //添加入住信息
            int result = roomService.insertInRoom(inRoom);
            // 修改 房间状态 至为 入住状态
            roomService.updateRoomStatus(inRoom.getRoomCode(), 2, inRoom.getId());
            // 如果 是预定 入住  则修改预定 订单状态为已办理入住
            if (room.getStatus() == 1) {
                roomService.updateReservationStatus(room.getOrderCode());
            }
            if (result > 0) {
                return inRoom;
            }
        }
        return "error";
    }

    /***
     * 办理换房
     * @param params
     * @return
     */
    @PostMapping(value = "/changeRoom", produces = "application/json;charset=UTF-8")
    public Object changeRoom(@RequestBody Map<String,RoomAll> params){
        RoomAll nowRoom = params.get("nowRoom");
        RoomAll changeRoom = params.get("changeRoom");
        changeRoom.setOrderCode(nowRoom.getOrderCode());
        roomService.updateRoomStatus(changeRoom.getCode(),2,changeRoom.getOrderCode());
        roomService.updateRoomStatus(nowRoom.getCode(),0,0);
        InRoom inRoom = new InRoom();
        inRoom.setId(nowRoom.getOrderCode());
        inRoom.setRoomCode(changeRoom.getCode());
        inRoom.setRoomFloor(changeRoom.getFloor());
        inRoom.setRoomPrise(changeRoom.getPrise());
        inRoom.setRoomType(changeRoom.getType());
        inRoom.setRoomTypeName(changeRoom.getTypeName());
        int i =roomService.changeRoom(inRoom);
        return i;
    }


    /**
     * @author: lbc <.*)#)))<
     * @date: 2019年5月8日 上午 9:06
     * @Description: 通过ID查询该条预定信息
     * @updateUser:
     * @updateDate: 2019年5月8日 上午 9:06
     * @updateDescription:  
     * @param: [params ]
     * @throws: 
     **/
    @PostMapping(value = "/getReservationById", produces = "application/json;charset=UTF-8")
    public Object getReservationById(@RequestBody Map<String, String> params) {
        int id = Integer.parseInt(params.get("id"));
        Reservation result = roomService.getReservationById(id);
        return result;
    }

    /**
     * 查询所有 预定记录
     * @return
     */
    @PostMapping(value = "/getAllReservation")
    public Object getAllReservation() {
        List<Reservation> reservations = roomService.getAllReservation();
        return reservations;
    }

    /**
     * 查询所有 入住记录
     * @return
     */
    @PostMapping(value = "/getAllInRoom")
    public Object getAllInRoom() {
        //前往数据库查询 所有入住记录
        List<InRoom> inRooms = roomService.getAllInRoom();
        //返回查询结果
        return inRooms;
    }

    /**
     * 查询所有 离店记录
     * @return
     */
    @PostMapping(value = "/getAllOutRoom")
    public Object getAllOutRoom() {
        List<OutRoom> outRooms = roomService.getAllOutRoom();
        return outRooms;
    }

    /**
     * 离店管理 办理退房
     *
     * @param inRoom
     * @return
     */
    @PostMapping(value = "/insertOutRoom", produces = "application/json;charset=UTF-8")
    public Object insertOutRoom(@RequestBody OutRoom outRoom ) {
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

    /**
     * @author: lbc <.*)#)))<
     * @date: 2019年5月8日 上午 9:07
     * @Description: 通过ID获取该条入住信息
     * @updateUser:
     * @updateDate: 2019年5月8日 上午 9:07
     * @updateDescription:  
     * @param: [params]
     * @throws: 
     **/
    @PostMapping(value = "/getInRoomById", produces = "application/json;charset=UTF-8")
    public Object getInRoomById(@RequestBody Map<String, String> params) {
        int id = Integer.parseInt(params.get("id"));
        InRoom result = roomService.getInRoomById(id);
        return result;
    }
}
