package com.lbh.calcapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    EditText e1,e2,e3;
    String s1,s2;
    double weight,time,k,result;

    Button button;
    RadioGroup radioGroup;
    RadioButton c1, c2, c3, c4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calury);
        initView();

        radioGroup.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    public void initView(){
        e1=findViewById(R.id.w_input);
        e2=findViewById(R.id.t_input);
        e3=findViewById(R.id.result_input);

        button = (Button) findViewById(R.id.btn_com);
        radioGroup=(RadioGroup)findViewById(R.id.radio);
        c1=(RadioButton) findViewById(R.id.RadioButton_bike);
        c2=(RadioButton) findViewById(R.id.RadioButton_run);
        c3=(RadioButton) findViewById(R.id.RadioButton_walk);
        c4=(RadioButton) findViewById(R.id.RadioButton_skate);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View view) {
        int id=view.getId();

        s1=e1.getText().toString();
        weight=Double.parseDouble(s1);
        s2=e2.getText().toString();
        time=Double.parseDouble(s2);
        result = weight * time * k;
        e3.setText(String.format("%.2f", result));
    }

    public void onRadioButtonClicked(View view){
        int id=view.getId();

        if (id==R.id.RadioButton_run) k=1.036;
        else if (id==R.id.RadioButton_bike) k=0.6142;
        else if (id==R.id.RadioButton_skate) k=0.518;
        else if (id==R.id.RadioButton_walk) k=0.8214;
    }
}

