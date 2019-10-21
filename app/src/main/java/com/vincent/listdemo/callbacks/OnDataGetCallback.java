package com.vincent.listdemo.callbacks;

public interface OnDataGetCallback<Item> {

    void onDataGet(Item item);

    void onDataGetFailed(String errorMessage);
}
