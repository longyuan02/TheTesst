package com.mazhan.theone.dagger2test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mazhan.theone.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dragonfly on 2017/4/13.
 */

public class DaggerMainActivity extends AppCompatActivity {
    @InjectView(R.id.recyclerview)
    RecyclerView recyclerview;
    @Inject
    RecyclerViewAdatper adatper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daggermain);
        ButterKnife.inject(this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        DaggerDaggerComponent.builder().daggerMainModule(new DaggerMainModule(this, this.getResources().getStringArray(R.array.titles))).build().inject(this);
        recyclerview.setAdapter(adatper);
    }
}
