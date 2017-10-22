package com.example.subwayapp;

import android.os.AsyncTask;

import com.example.subwayapp.jsonarrivalinfo.ArrivalTimeJSON;
import com.example.subwayapp.jsonarrivalinfo.Row;
import com.example.subwayapp.jsonarrivalinfo.SearchSTNTimeTableByIDService;
import com.example.subwayapp.jsonrealtimeinfo.SubwayInfoJSON;
import com.example.subwayapp.model.Remote;
import com.example.subwayapp.recyclerViewAdapter.TabLayoutListener;
import com.google.gson.Gson;

/**
 * Created by 정인섭 on 2017-10-22.
 */

public class ServerConnectForArr {
    ArrivalTimeJSON arrivalTimeJSON;
    SearchSTNTimeTableByIDService tableByIDService;
    Row row[];
    public void loadForArrival(final String string){

        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {

                return Remote.getData(string);
            }

            @Override
            protected void onPostExecute(String s) {
                Gson gson = new Gson();
                arrivalTimeJSON = gson.fromJson(s, ArrivalTimeJSON.class);
                System.out.println("onPostExecute 호출됨");
                tableByIDService = arrivalTimeJSON.getSearchSTNTimeTableByIDService();
                row = tableByIDService.getRow();

                System.out.println("과연 도착시간은?" + row[0].getARRIVETIME());

                //asyncToFragment.setRealTime(realtimeArrivalList);
                //list = subwayInfoJSON.getRealtimeArrivalList();
                //여기서 프래그먼트의 함수를 호출해서 결과값 전달
            }
        };
        asyncTask.execute();

        // Async는 비동기이므로 여기에 return realtimeArrivalList; 을 하게 되면 따로 돌게 된다.
        // 그래서 onPostExecute 안에서 프래그먼트의 함수가 실행되도록 해야한다.
    }
}
