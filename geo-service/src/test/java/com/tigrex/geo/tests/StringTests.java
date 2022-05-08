package com.tigrex.geo.tests;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StringTests {

    @Test
    public void concat() {
        String s = "Hello".toLowerCase().concat("SmsSupplier");
        System.out.println(s);
    }
    
    @Test
    public void encode() {
        String s = "123";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(s);
        System.out.println(encoder.upgradeEncoding(password));
        System.out.println(password);
    }
}
