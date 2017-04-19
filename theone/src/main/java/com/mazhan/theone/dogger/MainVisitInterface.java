package com.mazhan.theone.dogger;

import dagger.Component;

/**
 * Created by dragonfly on 2017/4/12.
 */
@Component(modules = MainModule.class)
public interface MainVisitInterface {
    void inject(MainActivity activity);
}
