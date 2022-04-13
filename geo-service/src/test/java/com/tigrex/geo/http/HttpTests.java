package com.tigrex.geo.http;

import com.tigrex.geo.utils.HttpUtils;
import org.junit.Test;

import java.io.IOException;

public class HttpTests {

    @Test
    public void testHttpUrl() throws IOException {
        HttpUtils.httpURLConnection();
    }

    @Test
    public void testHttpClients() throws IOException {
        HttpUtils.httpClients();
    }
}
