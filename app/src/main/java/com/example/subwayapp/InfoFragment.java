package com.example.subwayapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.subwayapp.jsonfile.RealtimeArrivalList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment implements AsyncToFragment {
    TabLayout tabLayout;
    TextView textView, tvStnTwoAhead, tvStnOneAhead, tvStnCurrent;
    ServerConnect serverConnect;
    RealtimeArrivalList realtimeArrivalList[];

    public InfoFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_info, container, false); //두번째 인자에 Viewgroup인 container를 넣어야 부모를 인식함,
        // 세번째 인자에 false를 하면 부모에에종속되지 않음, true를 하면 부모에 종속됨, The specified child already has a parent.와 같은 에러가 뜸
        view.setBackgroundColor(Color.WHITE);
        initView(view);
        tabLayoutSelectListener();

        setTextView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStart() {
        super.onStart();
        String stationName = getArguments().getString("stnName");
        serverConnect = new ServerConnect();
        serverConnect.load("http://swopenapi.seoul.go.kr/api/subway/696e614f506a69733131384952495246/" +
                "json/realtimeStationArrival/1/5/" + stationName, this);
    }

    private void initView(View view) {
        tabLayout = view.findViewById(R.id.tabLayout);
        textView = view.findViewById(R.id.textView);
        tvStnCurrent = view.findViewById(R.id.tvStnCurrent);
        tvStnOneAhead = view.findViewById(R.id.tvStnOneAhead);
        tvStnTwoAhead = view.findViewById(R.id.tvStnTwoAhead);
        tabLayout.addTab(tabLayout.newTab().setText("상행선"));
        tabLayout.addTab(tabLayout.newTab().setText("하행선"));
    }

    public void setTextView(){
        textView.setText(realtimeArrivalList[0].getStatnNm());
        tvStnCurrent.setText(realtimeArrivalList[0].getStatnFid());
    }

    public void tabLayoutSelectListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getContext(), tab.getPosition()+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public void setRealTime(RealtimeArrivalList realtimeArrivalList[]){
        System.out.println(realtimeArrivalList[0].getStatnNm());
    }





}
