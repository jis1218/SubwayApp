package com.example.subwayapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.subwayapp.jsonrealtimeinfo.RealtimeArrivalList;
import com.example.subwayapp.jsonrealtimeinfo.SubwayInfoJSON;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment{
    TabLayout tabLayout;
    TextView textView, tvStnTwoAhead, tvStnOneAhead, tvStnCurrent;
    ServerConnect serverConnect;
    RealtimeArrivalList realtimeArrivalList[];
    SubwayInfoJSON subwayInfoJSON;

    String tabLayoutStatus = "상행선";
    String upWay[];
    String downWay[];
    String upWayInfo;
    String prevStnUp;
    String downWayInfo;
    String prevStnDown;

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
        setInstance(realtimeArrivalList);
        initView(view);
        tabLayoutSelectListener();
        dividePrevStn();
        defaultSetTextView();
        setTextView();

        return view;
    }

    public void defaultSetTextView(){
        textView.setText(realtimeArrivalList[0].getStatnNm());
        tvStnCurrent.setText(realtimeArrivalList[0].getStatnNm());
        tabLayout.getTabAt(0).setText(prevStnDown + " 방향");
        tabLayout.getTabAt(1).setText(prevStnUp + " 방향");

    }

    public void setTextView(){
        if(tabLayoutStatus.equals("상행선")){
            tvStnOneAhead.setText(prevStnUp);
        }else{
            tvStnOneAhead.setText(prevStnDown);
        }
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

    public void dividePrevStn(){

        upWay = realtimeArrivalList[0].getTrainLineNm().split(" - ");
        downWay = realtimeArrivalList[1].getTrainLineNm().split(" - ");

        upWayInfo = upWay[0];
        prevStnUp = upWay[1].substring(0, upWay[1].length()-2);
        downWayInfo = downWay[0];
        prevStnDown = downWay[1].substring(0, downWay[1].length()-2);
    }

    public void setInstance(RealtimeArrivalList realtimeArrivalList[]){
        this.realtimeArrivalList = realtimeArrivalList;
    }

    public void tabLayoutSelectListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()){
                    case 0 :
                        tabLayoutStatus = "상행선";
                        break;
                    case 1 :
                        tabLayoutStatus = "하행선";
                }
                setTextView();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
