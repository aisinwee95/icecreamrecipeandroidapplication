package com.weeaisin.android.icecreamrecipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by AiLeng on 05-Mar-17.
 */

public class Tab1 extends Fragment {

    private TextView txt1;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        View view = inflater.inflate(R.layout.tab1, container, false);

        TextView txt1 = (TextView)view.findViewById(R.id.textView1);
        txt1.setText("1½  cups half and half\n" + "\n" +
              "1½ cup packed brown sugar\n" + "\n" +
              "½  cup white sugar\n" + "\n" +
              "⅛  teaspoon salt\n" + "\n" +
              "2  eggs, beaten\n" + "\n" +
              "1  cup heavy whipping cream\n" + "\n" +
              "1½ teaspoon vanilla extract\n" + "\n" +
              "2  very ripe bananas, mashed\n" + "\n" +
              "1  cup crushed Nilla wafers");

        return view;
    }

}
