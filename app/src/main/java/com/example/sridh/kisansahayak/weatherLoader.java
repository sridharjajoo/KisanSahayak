package com.example.sridh.kisansahayak;

/**
 * Created by SatyamBansal on 06-11-2016.
 */


import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by SatyamBansal on 06-11-2016.
 */

public class weatherLoader extends AsyncTaskLoader<List<Weather>> {

    String mUrl;
    public weatherLoader(Context context , String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<Weather> loadInBackground() {
        if(mUrl == null){
            return null;
        }
        List result =  WebUtils.extractEarthquakes(mUrl);
        return result;
    }

    @Override
    protected void onStartLoading() {


        forceLoad();

    }
}
