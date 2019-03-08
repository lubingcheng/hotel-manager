package com.lhl.hotelmanager.controller;

import com.lhl.hotelmanager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping(value = "/getAllRoom")
    public List getAllRoom() {
        List result = roomService.getAllRoom();
        return result;
    }

}
