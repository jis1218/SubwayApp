package com.example.subwayapp.recyclerViewAdapter;

import android.os.Bundle;

import com.example.subwayapp.jsonrealtimeinfo.RealtimeArrivalList;

/**
 * Created by 정인섭 on 2017-10-19.
 */

public interface TabLayoutListener {
    void tabLayoutInflater(RealtimeArrivalList realtimeArrivalList[]);
    String getSpinnerPosition();
    void setClickedInfo(Bundle bundle);
}
