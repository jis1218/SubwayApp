package com.example.subwayapp.recyclerViewAdapter;

import android.os.Bundle;

/**
 * Created by 정인섭 on 2017-10-19.
 */

public interface TabLayoutListener {
    void tabLayoutInflater(Bundle bundle);
    String getSpinnerPosition();
    void setClickedInfo(Bundle bundle);
}
