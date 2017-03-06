package com.weeaisin.android.icecreamrecipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tab3 extends Fragment implements OnClickListener {

    TextView txt1;
    TextView txt2;

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    /** Called when the activity is first created. */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        View view = inflater.inflate(R.layout.tab3, container, false);

        // find the elements
        txt1 = (TextView) view.findViewById(R.id.txt1);
        txt2 = (TextView) view.findViewById(R.id.txt2);

        etNum1 = (EditText) view.findViewById(R.id.etNum1);
        etNum2 = (EditText) view.findViewById(R.id.etNum2);

        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        btnSub = (Button) view.findViewById(R.id.btnSub);
        btnMult = (Button) view.findViewById(R.id.btnMult);
        btnDiv = (Button) view.findViewById(R.id.btnDiv);

        tvResult = (TextView) view.findViewById(R.id.tvResult);

        // set a listener
        btnAdd.setOnClickListener((OnClickListener) this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // form the output line
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
}
