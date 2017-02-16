package com.example.sridh.kisansahayak;

import android.widget.ImageView;

/**
 * Created by sridh on 05-11-2016.
 */

public class gridview_items
{
     private String mname;
     private int mimage;

    public gridview_items(String name){

        mname = name;
        //mimage = imageId;
    }

    public String getname(){
        return mname;
    }

    public int getImage(){
        return mimage;
    }
}
