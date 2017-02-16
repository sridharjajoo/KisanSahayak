package com.example.sridh.kisansahayak;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Help extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView button = (TextView) findViewById(R.id.magnitude);
        TextView button1 = (TextView) findViewById(R.id.magnitude2) ;
        TextView button2 = (TextView) findViewById(R.id.magnitude3) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call1();

    }
});
    }

    private void call1() {
        Intent in=new Intent(Intent.ACTION_CALL,Uri.parse("tel:9718051114"));
        try{
            startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }

    private void call2() {
        Intent in=new Intent(Intent.ACTION_CALL,Uri.parse("tel:8287391905"));
        try{
            startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }

    private void call3() {
        Intent in=new Intent(Intent.ACTION_CALL,Uri.parse("tel:9718051114"));
        try{
            startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
        }
    }
}