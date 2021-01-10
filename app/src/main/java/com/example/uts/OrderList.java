package com.example.uts;

import java.util.ArrayList;

public class OrderList {
    final ArrayList<Order> OL = new ArrayList<>();

    static OrderList getInstance() {
        if( instance == null ) {
            instance = new OrderList();
        }
        return instance;
    }

    private static OrderList instance;
}
