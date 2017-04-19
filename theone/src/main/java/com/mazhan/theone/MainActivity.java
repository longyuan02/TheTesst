package com.mazhan.theone;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements InterfaceViews{
    TextView tv_third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_third= (TextView) findViewById(R.id.tv_third);
//        Button btn_click= (Button) findViewById(R.id.btn_click);
//        btn_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_SHORT).show();
//            }
//        });
        tv_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"hello third word",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void getValueSc(String data) {
        Log.i("dfdfdfd===",data);
//        LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
//        View view=inflater.inflate(R.layout.activity_main,null);
//        TextView tv_third= (TextView) view.findViewById(R.id.tv_third);
//        tv_third.setText(data);
    }
}
