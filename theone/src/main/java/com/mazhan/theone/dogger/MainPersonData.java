package com.mazhan.theone.dogger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dragonfly on 2017/4/12.
 */
@Module
public class MainPersonData {
    @Provides
    public Person provedPersonModule() {
        return new Person(21, "11");
    }
}
