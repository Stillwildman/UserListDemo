package com.vincent.listdemo.paging;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.vincent.listdemo.bases.BasePageConfig;
import com.vincent.listdemo.callbacks.PagingStatusCallback;
import com.vincent.listdemo.model.ItemsUser;

public class UserDataRepo extends BasePageConfig {

    private final PagingStatusCallback statusCallback;

    public UserDataRepo(PagingStatusCallback statusCallback) {
        this.statusCallback = statusCallback;
    }

    public LiveData<PagedList<ItemsUser.UserInfo>> getUserList() {
        return new LivePagedListBuilder<>(new UserDataSourceFactory(statusCallback), getConfig())
                .setInitialLoadKey(getInitialPageKey())
                .build();
    }

    @Override
    protected int getPageSize() {
        return 6;
    }

    @Override
    protected int getInitialPageKey() {
        return 1;
    }
}
