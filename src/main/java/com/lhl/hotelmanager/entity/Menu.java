package com.lhl.hotelmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: hotel-manager
 * @Date: 2019/3/2 0002 下午 3:53
 * @Author: <.*)#)))<
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private int id;

    private String menuName;

    private String menuCode;

    private int parentMenu;

    private String creatUser;

    private String creatTime;

    private String icon;

    private int order;

    private List<Menu> children;

}
