package com.controller;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    @Test
    public void main(){
        Date nowDate = new Date();
        System.out.println(nowDate.after(nowDate));
        System.out.println(nowDate + "//" + new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(nowDate));
    }
}
