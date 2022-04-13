package com.tigrex.geo.utils;

import com.tigrex.geo.entity.po.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author linus
 */
@Slf4j
public class HttpUtils {

    public static void httpURLConnection() throws IOException {
        URL url = new URL("http://localhost:9001/user/hello");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
        xml += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
        xml += "<soap:Body>";
        xml += "<mt xmlns=\"http://localhost:9001/\">";
        xml += "<sn>" + 123 + "</sn>";
        xml += "<pwd>" + 123 + "</pwd>";
        xml += "<mobile>" + 123 + "</mobile>";
        xml += "<content>" + 123 + "</content>";
        xml += "<ext>" + 123 + "</ext>";
        xml += "<stime>" + 123 + "</stime>";
        xml += "<rrid></rrid>";
        xml += "</mt>";
        xml += "</soap:Body>";
        xml += "</soap:Envelope>";

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        bout.write(xml.getBytes());
        byte[] b = bout.toByteArray();
        connection.setRequestProperty("Content-Length", String.valueOf(b.length));
        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        connection.setRequestProperty("SOAPAction", "http://localhost:9001/user/hello");
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();
        out.write(b);
        out.close();

        InputStreamReader isr = new InputStreamReader(connection.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String inputLine;
        while (null != (inputLine = in.readLine())) {
            sb.append(inputLine);
        }
        System.out.println(sb);
    }

    public static void httpClients() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createMinimal();
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", "george"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
        HttpPost postMethod = new HttpPost("http://localhost:9001/user/hello");
        postMethod.setEntity(entity);
        RequestConfig config = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(10000)
                .setSocketTimeout(10000).build();
        postMethod.setConfig(config);
        HttpResponse response = httpClient.execute(postMethod);
        log.info(response.toString());
    }
}
