package com.example.subwayapp.jsonfile;

/**
 * Created by 정인섭 on 2017-10-19.
 */

public class RealtimeArrivalList {
    private String statnList;

    private String statnFid;

    private String selectedCount;

    private String btrainNo;

    private String subwayList;

    private String statnTid;

    private String subwayId; // 지하철 호선

    private String totalCount;

    private String statnNm; // 지하철역 이름

    private String bstatnNm; // 종착 지하철역 이름

    private String recptnDt;

    private String arvlCd; // 도착 코드

    private String bstatnId; // 종착 지하철역 아이디

    private String barvlDt;

    private String subwayHeading;

    private String btrainSttus; //열차종류            (급행,ITX)

    private String arvlMsg3; //두번째도착메세지 (종합운동장 도착, 12분 후 (광명사거리) 등)

    private String arvlMsg2; //첫번째도착메세지 (전역 진입, 전역 도착 등)

    private String updnLine;

    private String trainLineNm;

    private String ordkey;

    private String rowNum;

    private String statnId;


    public String getStatnList ()
    {
        return statnList;
    }

    public void setStatnList (String statnList)
    {
        this.statnList = statnList;
    }

    public String getStatnFid ()
    {
        return statnFid;
    }

    public void setStatnFid (String statnFid)
    {
        this.statnFid = statnFid;
    }

    public String getSelectedCount ()
    {
        return selectedCount;
    }

    public void setSelectedCount (String selectedCount)
    {
        this.selectedCount = selectedCount;
    }

    public String getBtrainNo ()
    {
        return btrainNo;
    }

    public void setBtrainNo (String btrainNo)
    {
        this.btrainNo = btrainNo;
    }

    public String getSubwayList ()
    {
        return subwayList;
    }

    public void setSubwayList (String subwayList)
    {
        this.subwayList = subwayList;
    }

    public String getStatnTid ()
    {
        return statnTid;
    }

    public void setStatnTid (String statnTid)
    {
        this.statnTid = statnTid;
    }

    public String getSubwayId ()
    {
        return subwayId;
    }

    public void setSubwayId (String subwayId)
    {
        this.subwayId = subwayId;
    }

    public String getTotalCount ()
    {
        return totalCount;
    }

    public void setTotalCount (String totalCount)
    {
        this.totalCount = totalCount;
    }

    public String getStatnNm ()
    {
        return statnNm;
    }

    public void setStatnNm (String statnNm)
    {
        this.statnNm = statnNm;
    }

    public String getBstatnNm ()
    {
        return bstatnNm;
    }

    public void setBstatnNm (String bstatnNm)
    {
        this.bstatnNm = bstatnNm;
    }

    public String getRecptnDt ()
    {
        return recptnDt;
    }

    public void setRecptnDt (String recptnDt)
    {
        this.recptnDt = recptnDt;
    }

    public String getArvlCd ()
    {
        return arvlCd;
    }

    public void setArvlCd (String arvlCd)
    {
        this.arvlCd = arvlCd;
    }

    public String getBstatnId ()
    {
        return bstatnId;
    }

    public void setBstatnId (String bstatnId)
    {
        this.bstatnId = bstatnId;
    }


    public String getBarvlDt ()
    {
        return barvlDt;
    }

    public void setBarvlDt (String barvlDt)
    {
        this.barvlDt = barvlDt;
    }

    public String getSubwayHeading ()
    {
        return subwayHeading;
    }

    public String getBtrainSttus() {
        return btrainSttus;
    }

    public void setBtrainSttus(String btrainSttus) {
        this.btrainSttus = btrainSttus;
    }

    public void setSubwayHeading (String subwayHeading)
    {
        this.subwayHeading = subwayHeading;
    }

    public String getArvlMsg3 ()
    {
        return arvlMsg3;
    }

    public void setArvlMsg3 (String arvlMsg3)
    {
        this.arvlMsg3 = arvlMsg3;
    }

    public String getArvlMsg2 ()
    {
        return arvlMsg2;
    }

    public void setArvlMsg2 (String arvlMsg2)
    {
        this.arvlMsg2 = arvlMsg2;
    }

    public String getUpdnLine ()
    {
        return updnLine;
    }

    public void setUpdnLine (String updnLine)
    {
        this.updnLine = updnLine;
    }

    public String getTrainLineNm ()
    {
        return trainLineNm;
    }

    public void setTrainLineNm (String trainLineNm)
    {
        this.trainLineNm = trainLineNm;
    }

    public String getOrdkey ()
    {
        return ordkey;
    }

    public void setOrdkey (String ordkey)
    {
        this.ordkey = ordkey;
    }

    public String getRowNum ()
    {
        return rowNum;
    }

    public void setRowNum (String rowNum)
    {
        this.rowNum = rowNum;
    }


    public String getStatnId ()
    {
        return statnId;
    }

    public void setStatnId (String statnId)
    {
        this.statnId = statnId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [statnList = "+statnList+", statnFid = "+statnFid+", selectedCount = "+selectedCount+", btrainNo = "+btrainNo+", subwayList = "+subwayList+", statnTid = "+statnTid+", subwayId = "+subwayId+", totalCount = "+totalCount+", statnNm = "+statnNm+", bstatnNm = "+bstatnNm+", recptnDt = "+recptnDt+", arvlCd = "+arvlCd+", bstatnId = "+bstatnId+", barvlDt = "+barvlDt+", subwayHeading = "+subwayHeading+", btrainSttus = "+btrainSttus+", arvlMsg3 = "+arvlMsg3+", arvlMsg2 = "+arvlMsg2+", updnLine = "+updnLine+", trainLineNm = "+trainLineNm+", ordkey = "+ordkey+", rowNum = "+rowNum+", statnId = "+statnId+"]";
    }

}
