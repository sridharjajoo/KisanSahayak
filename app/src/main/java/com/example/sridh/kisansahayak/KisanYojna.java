package com.example.sridh.kisansahayak;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class KisanYojna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisan_yojna);

        ArrayList<String> yojna = new ArrayList<>();
        yojna.add(0 ,"Crop Insurance Scheme");
        yojna.add(1 ,"PradhanMantri Awas Yojna");
        yojna.add(2 ,"Urja Ganga");
        yojna.add(3 ,"Bachat Lamp Yojna");
        yojna.add(4 ,"Central Government Health Scheme");
        yojna.add(5 ,"Deendayal Disabled Rehabilitation Scheme");
        yojna.add(6 ,"Gramin Bhandaran Yojana");
        yojna.add(7 ,"Indira Awaas Yojana");
        yojna.add(8 ,"Janani Suraksha Yojana");
        yojna.add(9 ,"Jawaharlal Nehru National Urban Renewal Mission (JnNURM)");



        ListView list = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1 ,yojna);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String murl;
                Intent mintent;
                switch(position){

                    case 0:
                        murl = "http://agri-insurance.gov.in/StateWiseCompCrop.aspx";
                        mintent = new Intent(Intent.ACTION_VIEW);
                        mintent.setData(Uri.parse(murl));
                        startActivity(mintent);
                        break;

                    case 1:
                        murl = "http://pmaymis.gov.in/";
                        mintent = new Intent(Intent.ACTION_VIEW);
                        mintent.setData(Uri.parse(murl));
                        startActivity(mintent);

                    case 2:
                        murl = "http://www.pradhanmantriyojana.co.in/urja-ganga-gas-pipeline-project/";
                        mintent = new Intent(Intent.ACTION_VIEW);
                        mintent.setData(Uri.parse(murl));
                        startActivity(mintent);
                        break;

                    case 3:
                        murl= "https://www.bijlibachao.com/government-programs/bachat-lamp-yojna-bly-a-scheme-by-bee-to-promote-energy-efficient-lighting.html";
                        mintent = new Intent(Intent.ACTION_VIEW);
                        mintent.setData(Uri.parse(murl));
                        startActivity(mintent);
                        break;

                    case 4:
                        murl = "http://cghs.nic.in/";
                        mintent = new Intent(Intent.ACTION_VIEW);
                        mintent.setData(Uri.parse(murl));
                        startActivity(mintent);
                        break;

                    case 5:
                        murl = "http://disabilityaffairs.gov.in/content/page/ddrs.php";
                        Intent i1 = new Intent(Intent.ACTION_VIEW);
                        i1.setData(Uri.parse(murl));
                        startActivity(i1);
                        break;

                    case 6:
                        murl = "http://vikaspedia.in/agriculture/policies-and-schemes/crops-related/gramin-bhandaran-yojana";
                        Intent i5 = new Intent(Intent.ACTION_VIEW);
                        i5.setData(Uri.parse(murl));
                        startActivity(i5);
                        break;

                    case 7:
                        murl = "http://iay.nic.in/netiay/home.aspx";
                        Intent i4 = new Intent(Intent.ACTION_VIEW);
                        i4.setData(Uri.parse(murl));
                        startActivity(i4);
                        break;

                    case 8:
                        murl = "http://nrhm.gov.in/nrhm-components/rmnch-a/maternal-health/janani-suraksha-yojana/background.html";
                        Intent i3 = new Intent(Intent.ACTION_VIEW);
                        i3.setData(Uri.parse(murl));
                        startActivity(i3);
                        break;

                    case 9:
                        murl = "http://jnnurm.nic.in/";
                        Intent i2 = new Intent(Intent.ACTION_VIEW);
                        i2.setData(Uri.parse(murl));
                        startActivity(i2);
                        break;









                }

            }
        });

    }
}