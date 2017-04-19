package com.mazhan.theone.dogger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.mazhan.theone.R;
import javax.inject.Inject;

/**
 * Created by dragonfly on 2017/4/12.
 */

public class MainActivity extends AppCompatActivity implements MainContract.view {
    //    private MainPresenter mainPresenter;
    @Inject
    MainPresenter mainPresenter;
//    @Inject
//    Person person;
    private MainPersonDataActivity mainPersonDataActivity;
    private MainVisitInterface mainVisitInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_third = (TextView) findViewById(R.id.tv_third);
//        mainPersonDataActivity=DaggerMainPersonDataActivity.builder().build();
        mainVisitInterface=DaggerMainVisitInterface.builder().mainModule(new MainModule(this)).build();
        mainVisitInterface.inject(this);
        mainPresenter.Updata();
//        tv_third.setText("姓名：" + person.getAge() + "年龄：" + person.getName());
    }

    @Override
    public void updata() {
        Toast.makeText(this, "Updata", Toast.LENGTH_SHORT).show();
    }
}
