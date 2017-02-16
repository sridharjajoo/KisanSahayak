package com.example.sridh.kisansahayak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayList<String> items = new ArrayList();
        items.add("Commodity");
        //items.add("CropInfo");
        items.add("Weather");
        items.add("GovtYojna");
        items.add("WhatsappGroup");
        //items.add("News");
        items.add("Help");
        //items.add("Budget");


        GridView gridView = (GridView) findViewById(R.id.grid_view);
        ArrayAdapter adapter = new ArrayAdapter(this ,android.R.layout.simple_list_item_1,items );
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                if(position ==0){
                    Intent intent = new Intent(MainActivity.this , Commodity.class);
                    startActivity(intent);
                }

                else if(position ==4){
                    Intent intent = new Intent(MainActivity.this , Help.class);
                    startActivity(intent);
                }


                else if(position ==1){
                    Intent intent = new Intent(MainActivity.this , WeatherActivity.class);
                    startActivity(intent);
                }

                else if(position ==2){
                    Intent intent = new Intent(MainActivity.this , KisanYojna.class);
                    startActivity(intent);
                }

                else if(position ==3){
                    Intent intent = new Intent(MainActivity.this , Whatsapp.class);
                    startActivity(intent);
                }


            }
        });
    }



}
