package com.lhl.hotelmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: hotel-manager
 * @Date: 2018/11/13 0013 下午 7:10
 * @Author: <.*)#)))<
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private int id;

    private int floor;

    private int type;

    private String typeName;

    private double prise;

}
