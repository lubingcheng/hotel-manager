package com.lhl.hotelmanager.serviceImpl;

import com.lhl.hotelmanager.dao.RoomDao;
import com.lhl.hotelmanager.entity.Room;
import com.lhl.hotelmanager.entity.RoomAll;
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
    public List getAllRoom() {
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
}
