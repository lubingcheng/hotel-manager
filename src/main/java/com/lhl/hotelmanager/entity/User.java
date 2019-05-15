package com.lhl.hotelmanager.entity;

/**
 * @program: hotel-manager
 * @Date: 2018/11/6 0006 下午 6:59
 * @Author: <.*)#)))<
 * @Description:
 */

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{

    private int id;

    private String userName;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    private String sex;

    private String address;

    private String passWord;

    private String realName;

    private String idCard;



}
