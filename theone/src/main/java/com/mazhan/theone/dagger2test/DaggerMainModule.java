package com.mazhan.theone.dagger2test;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dragonfly on 2017/4/13.
 */
@Module
public class DaggerMainModule {
    private Context dcontext;
    private String[] lists;

    public DaggerMainModule(Context context, String[] stringlist) {
        this.dcontext = context;
        this.lists = stringlist;
    }

    @Provides
    Context provideActivityContext() {
        return dcontext;
    }

    @Provides
    String[] providerActiivtyList() {
        return lists;
    }
}
