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

import java.io.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

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


    public Object deepCopt() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);

            oos.writeObject(this);
            //将当前这个对象写到一个输出流当中，，因为这个对象的类实现了Serializable这个接口，所以在这个类中
            //有一个引用，这个引用如果实现了序列化，那么这个也会写到这个输出流当中

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            return ois.readObject();
        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
        //这个就是将流中的东西读出类，读到一个对象流当中，这样就可以返回这两个对象的东西，实现深克隆
    }


}
