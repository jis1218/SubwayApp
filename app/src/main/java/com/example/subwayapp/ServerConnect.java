package com.example.subwayapp;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.subwayapp.jsonfile.RealtimeArrivalList;
import com.example.subwayapp.jsonfile.SubwayInfoJSON;
import com.example.subwayapp.model.Remote;
import com.google.gson.Gson;

import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-10-19.
 */

public class ServerConnect extends Thread {
    SubwayInfoJSON subwayInfoJSON;
    RealtimeArrivalList realtimeArrivalList[];
    public ArrayList<RealtimeArrivalList> list;

    public ServerConnect() {
    }

    public void load(final String string, final AsyncToFragment asyncToFragment){

        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {

                return Remote.getData(string);
            }

            @Override
            protected void onPostExecute(String s) {
                Gson gson = new Gson();
                subwayInfoJSON = gson.fromJson(s, SubwayInfoJSON.class);
                System.out.println("onPostExecute 호출됨");
                realtimeArrivalList = subwayInfoJSON.getRealtimeArrivalList();
                System.out.println("과연" + realtimeArrivalList[0].getStatnNm());
                asyncToFragment.setRealTime(realtimeArrivalList);
                //list = subwayInfoJSON.getRealtimeArrivalList();
                //여기서 프래그먼트의 함수를 호출해서 결과값 전달


            }
        };
        asyncTask.execute();

        // Async는 비동기이므로 여기에 return realtimeArrivalList; 을 하게 되면 따로 돌게 된다.
        // 그래서 onPostExecute 안에서 프래그먼트의 함수가 실행되도록 해야한다.
    }
}

interface AsyncToFragment{
    void setRealTime(RealtimeArrivalList realtimeArrivalList[]);

}
