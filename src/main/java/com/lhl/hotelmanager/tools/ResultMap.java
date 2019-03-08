package com.lhl.hotelmanager.tools;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: hotel-manager
 * @Date: 2018/11/12 0012 下午 6:27
 * @Author: <.*)#)))<
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor  //lombok 自动生成无参构造函数
@AllArgsConstructor //lombok 自动生成所有参数构造函数
public class ResultMap {

    private boolean success;

    private String code;

    private Object errorMessage;

    private Object data;

    @Override
    public String toString() {
        return "RestResult{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", data=" + data +
                ", errorMessage=" + errorMessage +
                '}';
    }


}
