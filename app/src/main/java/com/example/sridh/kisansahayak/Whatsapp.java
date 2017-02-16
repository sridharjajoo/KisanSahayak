package com.example.sridh.kisansahayak;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Whatsapp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        ImageView image_what = (ImageView) findViewById(R.id.whatsapp);
        Button button = (Button) findViewById(R.id.whatsapp_group);

        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText("If you dont have a WhatsApp Account click on the following link and then get added to the group");
        TextView group= (TextView) findViewById(R.id.group);
        group.setText("Or else click on the following link to join a group0");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://chat.whatsapp.com/GGASuxbxkFEFcKTAPDgRkN";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });

        image_what.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.whatsapp.com/android/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                //startActivity(new Intent(Whatsapp.this , ));
            }


        });
    }
}
