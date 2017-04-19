package com.mazhan.theone.dogger;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by dragonfly on 2017/4/12.
 */
@Module
public class MainModule {
    private final MainContract.view mView;

    public MainModule(MainContract.view view) {
        mView = view;
    }

    @Provides
    MainContract.view provideMainView() {
        return mView;
    }
}

//@Component(modules = MainModule.class)
//interface MainComponent {
//    void inject(MainActivity activity);
//}
