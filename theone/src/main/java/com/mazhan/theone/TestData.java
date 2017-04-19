package com.mazhan.theone;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dragonfly on 2017/3/6.
 */

public class TestData implements Parcelable{
    private String name;
    private int old;

    protected TestData(Parcel in) {
        this.name=in.readString();
        this.old=in.readInt();
    }

    public static final Creator<TestData> CREATOR = new Creator<TestData>() {
        @Override
        public TestData createFromParcel(Parcel in) {
            return new TestData(in);
        }

        @Override
        public TestData[] newArray(int size) {
            return new TestData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.old);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}
