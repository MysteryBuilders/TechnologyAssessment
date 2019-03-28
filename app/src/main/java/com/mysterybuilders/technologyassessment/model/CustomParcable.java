package com.mysterybuilders.technologyassessment.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class CustomParcable implements Parcelable {
    private HashMap<String,String> map;
    public CustomParcable() {
        map = new HashMap();
    }
    private CustomParcable(Parcel in) {
        map = new HashMap();
        readFromParcel(in);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public CustomParcable createFromParcel(Parcel in) {
            return new CustomParcable(in);
        }

        public CustomParcable[] newArray(int size) {
            return new CustomParcable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(map.size());
        for (String s: map.keySet()) {
            dest.writeString(s);
            dest.writeString(map.get(s));
        }
    }

    public void readFromParcel(Parcel in) {
        int count = in.readInt();
        for (int i = 0; i < count; i++) {
            map.put(in.readString(), in.readString());
        }
    }

    public String get(String key) {
        return map.get(key);
    }

    public void put(String key, String value) {
        map.put(key, value);
    }
}
