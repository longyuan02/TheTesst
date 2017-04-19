package com.mazhan.theone.dogger;

import dagger.Component;
import dagger.Module;

/**
 * Created by dragonfly on 2017/4/12.
 */
@Component(modules = MainPersonData.class)
public interface MainPersonDataActivity {
    Person person();
}
