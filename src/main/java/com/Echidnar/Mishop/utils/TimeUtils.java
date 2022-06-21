package com.Echidnar.Mishop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    //获取当前时间的方法
    public static String getTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);
        return currentTime;
    }


}

