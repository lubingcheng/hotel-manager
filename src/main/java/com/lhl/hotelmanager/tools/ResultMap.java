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
@NoArgsConstructor
@AllArgsConstructor
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
