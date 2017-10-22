package com.example.subwayapp.jsonarrivalinfo;

/**
 * Created by 정인섭 on 2017-10-22.
 */

public class ArrivalTimeJSON {
    private SearchSTNTimeTableByIDService SearchSTNTimeTableByIDService;

    public SearchSTNTimeTableByIDService getSearchSTNTimeTableByIDService ()
    {
        return SearchSTNTimeTableByIDService;
    }

    public void setSearchSTNTimeTableByIDService (SearchSTNTimeTableByIDService SearchSTNTimeTableByIDService)
    {
        this.SearchSTNTimeTableByIDService = SearchSTNTimeTableByIDService;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SearchSTNTimeTableByIDService = "+SearchSTNTimeTableByIDService+"]";
    }
}
