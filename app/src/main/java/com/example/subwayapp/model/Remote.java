package com.example.subwayapp.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 정인섭 on 2017-10-19.
 */

public class Remote {
    public static String getData(String string) {

        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(string);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader isr = new InputStreamReader(connection.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String temp = "";
                while ((temp = br.readLine()) != null) {
                    builder.append(temp).append("\n");
                }
                System.out.println("ServerConnect, URL에 잘 연결되었습니다.");

                br.close();
                isr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ServerConnect, URL 실패하였습니다.");
        }
        return builder.toString();
    }

}

