package com.example.sridh.kisansahayak;

/**
 * Created by SatyamBansal on 06-11-2016.
 */

public class Weather {



    double mMaxTemp;
    double mMinTemp;
    long mTime;
    String mDescription;

    Weather(double maxTemp , double minTemp , String description , long time){

        mMaxTemp = maxTemp;
        mMinTemp = minTemp;
        mDescription = description;
        mTime = time;

    }

    public String getmDescription() {
        return mDescription;
    }

    public long getmTime() {
        return mTime;
    }

    public double getmMinTemp() {
        return mMinTemp;
    }

    public double getmMaxTemp() {
        return mMaxTemp;
    }
}
