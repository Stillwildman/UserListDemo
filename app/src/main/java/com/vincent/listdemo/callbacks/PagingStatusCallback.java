package com.vincent.listdemo.callbacks;

public interface PagingStatusCallback {

    void onLoading(boolean isLoading);

    void onFailed(String errorMessage);
}
