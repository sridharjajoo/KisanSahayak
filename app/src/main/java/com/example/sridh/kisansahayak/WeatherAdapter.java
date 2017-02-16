package com.example.sridh.kisansahayak;

/**
 * Created by SatyamBansal on 06-11-2016.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by SatyamBansal on 06-11-2016.
 */

public class WeatherAdapter extends ArrayAdapter<Weather> {
    public WeatherAdapter(Context context, ArrayList<Weather> data) {
        super(context, 0, data);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;

        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.item_list,parent,false);
        }
        Weather weatherdata = getItem(position);

        TextView minTempView = (TextView)listView.findViewById(R.id.minTemp_view);
        minTempView.setText(String.format( "%.1f", weatherdata.getmMinTemp()));

        TextView maxTempView = (TextView)listView.findViewById(R.id.maxTemp_view);
        maxTempView.setText(String.format("%.1f ", weatherdata.getmMaxTemp() ));

        TextView descriptionView = (TextView)listView.findViewById(R.id.description_view);
        descriptionView.setText(weatherdata.getmDescription());

        TextView dateView = (TextView)listView.findViewById(R.id.date_view);
        Log.v("WeatherAdapter.java" , "" + weatherdata.getmTime());
        String date = fomatDate(weatherdata.getmTime());
        dateView.setText(date);



        return listView;
    }

    private String fomatDate(Long dateObject){
        SimpleDateFormat convert = new SimpleDateFormat("dd MMM , yyyy");
        return  convert.format(dateObject*1000);

    }
}
