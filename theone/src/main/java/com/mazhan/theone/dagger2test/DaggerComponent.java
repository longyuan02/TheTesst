package com.mazhan.theone.dagger2test;

import dagger.Component;

/**
 * Created by dragonfly on 2017/4/13.
 */
@Component(modules = DaggerMainModule.class)
public interface DaggerComponent {
    void inject(DaggerMainActivity daggerMainActivity);
}
