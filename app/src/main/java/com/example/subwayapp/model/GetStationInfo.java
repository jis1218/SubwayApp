package com.example.subwayapp.model;

import android.content.Context;

import com.example.subwayapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-10-20.
 */

public class GetStationInfo {
    Context context;
    StationInfo stationInfo;
    ArrayList<StationInfo> list;

    public GetStationInfo(Context context) {
        this.context = context;
        list = new ArrayList<>();

    }


    public ArrayList<StationInfo> readData(){
        InputStream is = context.getResources().openRawResource(R.raw.info);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String temp;
        String info[];
        try {
            while ((temp = br.readLine()) != null) {
                info = temp.split(",");
                stationInfo = new StationInfo();
                stationInfo.setStnName(info[1]);
                stationInfo.setStnLine(info[2]);
                stationInfo.setStnID(info[3]);
                list.add(stationInfo);
            }
            br.close();
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return list;
    }

    public String getStnNameFromList(int position){
        return list.get(position).getStnName();
    }

    public String getStnLineFromList(int position){
        return list.get(position).getStnLine();
    }
}
