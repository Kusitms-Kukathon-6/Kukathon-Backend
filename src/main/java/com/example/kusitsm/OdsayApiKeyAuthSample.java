package com.example.kusitsm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class OdsayApiKeyAuthSample {

    public static void main(String[] args) throws IOException {

        // ODsay Api Key 정보
        String apiKey = "J0aZ0NhWM1ev/IC0nPfX4Cebxz0ByTU+3xMOCBLTFDc";

        String urlInfo = "https://api.odsay.com/v1/api/subwayPath?lang=0&CID=1000&SID=239&EID=241&Sopt=1&apiKey=" + URLEncoder.encode(apiKey, "UTF-8");

        // http 연결
        URL url = new URL(urlInfo);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();
        conn.disconnect();

        // 결과 출력
        System.out.println(sb.toString());

    }
}
               