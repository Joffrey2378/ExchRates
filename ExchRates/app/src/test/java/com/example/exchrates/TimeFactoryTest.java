package com.example.exchrates;

import org.junit.Test;

public class TimeFactoryTest {

    @Test
    public void giveYesterdayDate() {
        TimeFactory t = new TimeFactory();
        System.out.println(t.giveYesterdaysDate());
    }
}