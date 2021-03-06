package com.example.subwayapp;

import android.os.AsyncTask;

import com.example.subwayapp.jsonarrivalinfo.ArrivalTimeJSON;
import com.example.subwayapp.jsonarrivalinfo.Row;
import com.example.subwayapp.jsonarrivalinfo.SearchSTNTimeTableByIDService;
import com.example.subwayapp.jsonrealtimeinfo.ErrorMessage;
import com.example.subwayapp.jsonrealtimeinfo.RealtimeArrivalList;
import com.example.subwayapp.jsonrealtimeinfo.SubwayInfoJSON;
import com.example.subwayapp.model.Remote;
import com.example.subwayapp.recyclerViewAdapter.TabLayoutListener;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-10-19.
 */

public class ServerConnect extends Thread {
    SubwayInfoJSON subwayInfoJSON;
    RealtimeArrivalList realtimeArrivalList[];
    ArrivalTimeJSON arrivalTimeJSON;
    SearchSTNTimeTableByIDService tableByIDService;
    Row row;
    TabLayoutListener tabLayoutListener;

    ErrorMessage errorMessage;
    public ArrayList<RealtimeArrivalList> list;

    public ServerConnect() {

    }

    public void load(final String string, final TabLayoutListener tabLayoutListener){

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

                //asyncToFragment.setRealTime(realtimeArrivalList);
                //list = subwayInfoJSON.getRealtimeArrivalList();
                //여기서 프래그먼트의 함수를 호출해서 결과값 전달
                tabLayoutListener.tabLayoutInflater(realtimeArrivalList);


            }
        };
        asyncTask.execute();

        // Async는 비동기이므로 여기에 return realtimeArrivalList; 을 하게 되면 따로 돌게 된다.
        // 그래서 onPostExecute 안에서 프래그먼트의 함수가 실행되도록 해야한다.
    }


}

