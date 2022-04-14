package com.tigrex.geo.tkhos;

import com.tigrex.geo.utils.HttpUtils;
import org.junit.Test;

import java.io.IOException;

public class TkhosTests {

    @Test
    public void hello() throws IOException {
        HttpUtils.httpURLConnection("http://api-test.tkhos.tkhealthcare.com/tkhos-message-api/helloworld", "GET", "");
    }
}
