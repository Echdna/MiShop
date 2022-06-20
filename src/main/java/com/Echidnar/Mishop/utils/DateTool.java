package com.Echidnar.Mishop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
    public static Date stringToDate(String s){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String stringdate = s;
        Date date = new Date();
        try {
            //使用SimpleDateFormat的parse()方法生成Date
            date = sf.parse(stringdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}