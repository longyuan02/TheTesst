package com.mazhan.theone.dogger;

import javax.inject.Inject;

/**
 * Created by dragonfly on 2017/4/12.
 */

public class MainPresenter {
    private MainContract.view mainconstract;

    @Inject
    public MainPresenter(MainContract.view view) {
        mainconstract = view;
    }

    public void Updata() {
        mainconstract.updata();
    }
}
