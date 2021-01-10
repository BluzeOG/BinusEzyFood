package com.example.uts;

import android.os.Parcel;
import android.os.Parcelable;

public class coordinate implements Parcelable {

    private double x;
    private double y;
    private String name;

    protected coordinate(Parcel in) {
        x = in.readDouble();
        y = in.readDouble();
        name = in.readString();
    }

    public static final Creator<coordinate> CREATOR = new Creator<coordinate>() {
        @Override
        public coordinate createFromParcel(Parcel in) {
            return new coordinate(in);
        }

        @Override
        public coordinate[] newArray(int size) {
            return new coordinate[size];
        }
    };

    public coordinate() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(x);
        parcel.writeDouble(y);
        parcel.writeString(name);
    }
}
