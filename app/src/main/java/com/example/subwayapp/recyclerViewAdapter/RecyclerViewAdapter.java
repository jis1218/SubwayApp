package com.example.subwayapp.recyclerViewAdapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.subwayapp.R;
import com.example.subwayapp.ServerConnect;
import com.example.subwayapp.jsonfile.RealtimeArrivalList;
import com.example.subwayapp.model.GetStationInfo;
import com.example.subwayapp.model.StationInfo;
import com.example.subwayapp.model.StationName;

import java.util.ArrayList;

/**
 * Created by 정인섭 on 2017-10-19.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyHolder> {
    int spinner_position;
    StationName stationName;
    TabLayoutListener tabLayoutListener;
    GetStationInfo getStationInfo;
    ArrayList<StationInfo> list;
    Bundle bundle;



    public RecyclerViewAdapter(TabLayoutListener tabLayoutListener, Context context) {
        this.tabLayoutListener = tabLayoutListener;
        stationName = new StationName();
        getStationInfo = new GetStationInfo(context);
        list = getStationInfo.readData();
        bundle = new Bundle();

    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return getSpecificLine().size();
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null);

        return new MyHolder(view, tabLayoutListener);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.tvStation.setText(getSpecificLine().get(position).getStnName());
        holder.name = getSpecificLine().get(position).getStnName();
        //tabLayoutListener.setClickedInfo(bundle);
    }

    private ArrayList<StationInfo> getSpecificLine(){
        ArrayList<StationInfo> temp = new ArrayList<>();
        for(StationInfo info : list){
            if(info.getStnLine().equals(tabLayoutListener.getSpinnerPosition())){
                temp.add(info);
            }
        }
        return temp;
    }
}

class MyHolder extends RecyclerView.ViewHolder{
    String name;
    TextView tvStation;
    CardView cardView;
    ServerConnect serverConnect = new ServerConnect();;
    RealtimeArrivalList realtimeArrivalList[];
    public MyHolder(View itemView, final TabLayoutListener tabLayoutListener) {
        super(itemView);
        //tvStation = itemView.findViewById(R.id.tvStation);
        cardView = itemView.findViewById(R.id.cardView);
        tvStation = itemView.findViewById(R.id.tvStation);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //serverConnect = new ServerConnect();
                //realtimeArrivalList = serverConnect.load("http://swopenapi.seoul.go.kr/api/subway/696e614f506a69733131384952495246/json/realtimeStationArrival/1/5/대청");
                //System.out.println(tvStation.getText());
                Bundle bundle = new Bundle();
                bundle.putString("stnName", name);
                tabLayoutListener.tabLayoutInflater(bundle);


            }
        });

    }

    public void setTexttoTV(int position){
    }

}
