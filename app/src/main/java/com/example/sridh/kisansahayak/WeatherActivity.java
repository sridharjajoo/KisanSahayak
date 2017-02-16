package com.example.sridh.kisansahayak;


import android.app.LoaderManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class WeatherActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Weather>>{

    private static final String mUrl = "http://api.openweathermap.org/data/2.5/forecast/daily?lat=35&lon=139&cnt=10&mode=json&appid=216da1dcb8fcc8b8a4f32877c355301a";

    ArrayAdapter<Weather> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mAdapter = new WeatherAdapter(this,new ArrayList<Weather>());




        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);

        getLoaderManager().initLoader(1,null,this);

    }


    @Override
    public android.content.Loader<List<Weather>> onCreateLoader(int id, Bundle args) {
        return new weatherLoader(this,mUrl);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<Weather>> loader, List<Weather> data) {

        mAdapter.clear();

        if(data != null && !data.isEmpty()){
            mAdapter.addAll(data);

        }

    }


    @Override
    public void onLoaderReset(android.content.Loader<List<Weather>> loader) {

    }


}
