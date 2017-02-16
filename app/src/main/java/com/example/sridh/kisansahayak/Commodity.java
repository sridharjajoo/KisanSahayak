package com.example.sridh.kisansahayak;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
//import android.app.LoaderManager;
import java.util.ArrayList;

public class Commodity extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<ArrayList<KisanCommodity>> {


    private String SAMPLE_JSON_RESPONSE="https://data.gov.in/api/datastore/resource.json?resource_id=9ef84268-d588-465a-a308-a864a43d0070&api-key=93b2bccbb46d3e63b3e1eab8ee2de77b";
    private EditText editText;
    private String crop_name;
    private Button btn1;
    private int KISAN_LOADER_ID=1;
    private CommodityAdapter mcommodityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity);
        final android.app.LoaderManager loaderManager =getLoaderManager();

        ListView listView = (ListView) findViewById(R.id.list_view);
        mcommodityAdapter = new CommodityAdapter(this , new ArrayList<KisanCommodity>());
        listView.setAdapter(mcommodityAdapter);

        loaderManager.initLoader(KISAN_LOADER_ID, null ,this);
    }



    @Override
    public android.content.Loader<ArrayList<KisanCommodity>> onCreateLoader(int id, Bundle args) {
        Log.i("Commodity.java","Ruuuuuuuuuuuuuuuuuuuuuuuning");


        return new KisanLoader( this ,SAMPLE_JSON_RESPONSE  );


    }

    @Override
    public void onLoadFinished(android.content.Loader<ArrayList<KisanCommodity>> loader, ArrayList<KisanCommodity> data) {

             mcommodityAdapter.addAll(data);
    }

    @Override
    public void onLoaderReset(android.content.Loader<ArrayList<KisanCommodity>> loader) {

    }
}
