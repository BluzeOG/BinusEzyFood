package com.example.uts;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {
    private String ProductName, Restaurant;
    private int qty;
    private int price;



    @Override
    public String toString() {
        return this.getProductName();
    }

    public Order(String ProductName, int qty, int price){
        this.ProductName = ProductName;
        this.qty = qty;
        this.price = price;
    }

    public String getRestaurant() {
        return Restaurant;
    }

    public void setRestaurant(String restaurant) {
        Restaurant = restaurant;
    }

    protected Order(Parcel in) {
        ProductName = in.readString();
        qty = in.readInt();
        price = in.readInt();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public String getProductName() {
        return ProductName;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ProductName);
        parcel.writeInt(qty);
        parcel.writeInt(price);
    }
}
