package com.tigrex.geo.tests;

import org.junit.Test;

import java.time.Duration;

public class TimeTests {

    @Test
    public void testDuration() {
        Duration duration = Duration.ofSeconds(60L);
        System.out.println(duration.getSeconds());
    }
}
