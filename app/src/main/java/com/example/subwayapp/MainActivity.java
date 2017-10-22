package com.example.subwayapp;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.example.subwayapp.jsonrealtimeinfo.RealtimeArrivalList;
import com.example.subwayapp.model.GetStationInfo;
import com.example.subwayapp.recyclerViewAdapter.RecyclerViewAdapter;
import com.example.subwayapp.recyclerViewAdapter.TabLayoutListener;

public class MainActivity extends AppCompatActivity implements TabLayoutListener {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    RecyclerView recyclerView;
    FrameLayout frameLayout;
    RecyclerViewAdapter recyclerViewAdapter;
    ServerConnect serverConnect;
    TabLayout tabLayout;
    InfoFragment infoFragment;
    GetStationInfo getStationInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setSpinnerAdapter();
        setRecyclerView();

    }

    private void initView() {

        spinner = (Spinner) findViewById(R.id.spinner);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        frameLayout = (FrameLayout) findViewById(R.id.stage);
        infoFragment = new InfoFragment();

    }

    private void setSpinnerAdapter() {
        adapter = ArrayAdapter.createFromResource(this, R.array.subway_line, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                recyclerViewAdapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setRecyclerView() {
        recyclerViewAdapter = new RecyclerViewAdapter(this, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void tabLayoutInflater(RealtimeArrivalList realtimeArrivalList[]){
        //infoFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().addToBackStack("").add(R.id.container, infoFragment).commit();
        infoFragment.setInstance(realtimeArrivalList);


    }

    @Override
    public String getSpinnerPosition() {
        return (spinner.getSelectedItemPosition()+1) + "";
    }

    @Override
    public void setClickedInfo(Bundle bundle) {
        infoFragment.setArguments(bundle);
    }

    //    private void setServerConnect() {
//        serverConnect = new ServerConnect();
//        serverConnect.load()
//    }


}
