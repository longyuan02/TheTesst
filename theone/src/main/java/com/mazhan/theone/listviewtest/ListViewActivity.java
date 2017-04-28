package com.mazhan.theone.listviewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.mazhan.theone.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/26.
 */

public class ListViewActivity extends AppCompatActivity {
    @InjectView(R.id.lv)
    ListView lv;
    private ListViewAdapter adapter;
    private List<String> listdata = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_listviewmain);
        ButterKnife.inject(this);
        for (int i = 0; i < 11; i++) {
            listdata.add("信息" + i);
        }
        adapter = new ListViewAdapter(this);
        adapter.setList(listdata);
        lv.setAdapter(adapter);
    }
}
