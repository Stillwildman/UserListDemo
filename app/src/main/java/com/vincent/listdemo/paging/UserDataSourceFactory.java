package com.vincent.listdemo.paging;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.vincent.listdemo.callbacks.PagingStatusCallback;
import com.vincent.listdemo.model.ItemsUser;

public class UserDataSourceFactory extends DataSource.Factory<Integer, ItemsUser.UserInfo> {

    private final PagingStatusCallback statusCallback;

    UserDataSourceFactory(PagingStatusCallback statusCallback) {
        this.statusCallback = statusCallback;
    }

    @NonNull
    @Override
    public DataSource<Integer, ItemsUser.UserInfo> create() {
        return new UserDataSource(statusCallback);
    }
}
