package com.example.sridh.kisansahayak;

/**
 * Created by sridh on 05-11-2016.
 */

public class KisanCommodity {

    private  String mstate;
    private  String mmarket;
    private int mmaxprice;
    private  int mminprice;
    private String mcommodity;

public KisanCommodity(String state , String market ,int maxprice ,int minprice ,String commodity){

    mstate = state;
    mmarket = market;
    mmaxprice = maxprice;
    mminprice = minprice;
    mcommodity = commodity;
 }


    public  String getstate(){
        return mstate;
    }

    public  String getmarket(){
        return mmarket;
    }

    public  int getmaxprice(){
        return mmaxprice;
    }

    public  int getminprice(){
        return mminprice;
    }

    public String getcommodity(){ return mcommodity;}
}
