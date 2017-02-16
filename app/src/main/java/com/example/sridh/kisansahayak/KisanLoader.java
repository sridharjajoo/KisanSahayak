package com.example.sridh.kisansahayak;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by sridh on 05-11-2016.
 */

public class KisanLoader extends AsyncTaskLoader<ArrayList<KisanCommodity>> {

    private String mUrl,mcommodity;

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    public KisanLoader(Context context , String url){

             super(context);
             mUrl = url;
                 }


    @Override
    public ArrayList<KisanCommodity> loadInBackground() {
        Log.i("KisanLoader.java","inside Loader....................................");
        CommodityUtils query = new CommodityUtils();
        ArrayList<KisanCommodity> earthquakes = query.fetchCommodityData(mUrl);
        return earthquakes;


    }
}
