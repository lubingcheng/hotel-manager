package com.lhl.hotelmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: hotel-manager
 * @Date: 2018/11/13 0013 下午 7:10
 * @Author: <.*)#)))<
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    private int id;

    private int roomCode;

    private int roomFloor;

    private int roomType;

    private String roomTypeName;

    private double roomPrise;

    private String name;

    private String phone;

    private Date comeTime;

    private Date time;

    private Date inTime;

    private Date outTime;

    private int day;

    private int status;

}
