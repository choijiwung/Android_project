package com.rememberme.myparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JW on 2017-12-02.
 */

public class SimpleData implements Parcelable {

    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public SimpleData(Parcel src){
        number = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        public SimpleData createFromParcel(Parcel src){
            return new SimpleData(src);
        }
        public  SimpleData[] newArray(int Size){
            return new SimpleData[Size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
