package com.lhl.hotelmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: hotel-manager
 * @Date: 2019/3/8 0008 下午 3:43
 * @Author: <.*)#)))<
 * @Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

    private int id;

    private String name;

    private String idCard;

    private Date inTime;

    private Date leaveTime;

    private int roomCode;

    private int consume;

    private int status;

}
