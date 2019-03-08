package com.lhl.hotelmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: hotel-manager
 * @Date: 2019/3/8 0008 下午 3:51
 * @Author: <.*)#)))<
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomStatus {

    private int id;

    private int roomCode;

    private int status;
}
