package com.mazhan.theone.listviewtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.mazhan.theone.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/26.
 */

public class HideTitleListViewActivity extends AppCompatActivity {
    @InjectView(R.id.lv)
    ListView lv;
    private ListViewAdapter adapter;
    private List<String> listdata=new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_listviewmain);
        ButterKnife.inject(this);
        for (int i = 0; i < 11; i++) {
            listdata.add("信息" + i);
        }
        View headview=new View(this);
        headview.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,(int)getResources().getDimension(R.dimen.abc_action_bar_default_height_material)));
        lv.addHeaderView(headview);
        adapter=new ListViewAdapter(this);
        lv.setAdapter(adapter);
    }
    View.OnTouchListener onteouchlistener=new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    float mCurrent=event.getY();

                    break;
                case MotionEvent.ACTION_UP:
                default:
                    break;
            }
            return false;
        }
    };
}
