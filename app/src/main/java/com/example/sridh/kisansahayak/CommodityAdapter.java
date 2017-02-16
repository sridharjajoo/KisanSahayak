package com.example.sridh.kisansahayak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by sridh on 06-11-2016.
 */

public class CommodityAdapter extends ArrayAdapter<KisanCommodity> {


    public CommodityAdapter(Context context , ArrayList<KisanCommodity> commodities){
        super(context ,0 , commodities);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_commodity, parent, false);

        }

      KisanCommodity currentCommodity = getItem(position);

        TextView textView = (TextView) listItemView.findViewById(R.id.state);
        textView.setText(currentCommodity.getstate());

        TextView textView1 = (TextView) listItemView.findViewById(R.id.mandi);
        textView1.setText(currentCommodity.getmarket());

        TextView textView2 = (TextView) listItemView.findViewById(R.id.mincost);
        textView2.setText(""+currentCommodity.getminprice());

        TextView textView3 = (TextView) listItemView.findViewById(R.id.maxcost);
        textView3.setText(""+currentCommodity.getmaxprice());

        TextView textView4 = (TextView) listItemView.findViewById(R.id.commodity);
        textView4.setText(currentCommodity.getcommodity());

   return listItemView;

    }





}
