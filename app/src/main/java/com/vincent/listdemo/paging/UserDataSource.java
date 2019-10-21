package com.vincent.listdemo.paging;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.vincent.listdemo.callbacks.OnDataGetCallback;
import com.vincent.listdemo.callbacks.PagingStatusCallback;
import com.vincent.listdemo.model.ItemsUser;
import com.vincent.listdemo.network.DataCallbacks;

import java.util.ArrayList;

public class UserDataSource extends PageKeyedDataSource<Integer, ItemsUser.UserInfo> {

    private static final String TAG = "UserDataSource";

    private final PagingStatusCallback statusCallback;

    UserDataSource(PagingStatusCallback statusCallback) {
        this.statusCallback = statusCallback;
    }

    @Override
    public void loadInitial(@NonNull final LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, ItemsUser.UserInfo> callback) {
        statusCallback.onLoading(true);

        final int initialPage = 1;

        DataCallbacks.getUserData(initialPage, new OnDataGetCallback<ItemsUser>() {
            @Override
            public void onDataGet(ItemsUser userItem) {
                statusCallback.onLoading(false);

                Integer nextPageKey = userItem.getTotalPages() > initialPage ? initialPage + 1 : null;

                callback.onResult(new ArrayList<>(userItem.getUserInfoList()), null, nextPageKey);
            }

            @Override
            public void onDataGetFailed(String errorMessage) {
                statusCallback.onLoading(false);
                statusCallback.onFailed(errorMessage);
            }
        });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ItemsUser.UserInfo> callback) {
        statusCallback.onLoading(true);

        DataCallbacks.getUserData(params.key, new OnDataGetCallback<ItemsUser>() {
            @Override
            public void onDataGet(ItemsUser userItem) {
                statusCallback.onLoading(false);

                Integer previousPageKey = params.key <= 1 ? null : params.key - 1;

                callback.onResult(new ArrayList<>(userItem.getUserInfoList()), previousPageKey);
            }

            @Override
            public void onDataGetFailed(String errorMessage) {
                statusCallback.onLoading(false);
                statusCallback.onFailed(errorMessage);
            }
        });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, ItemsUser.UserInfo> callback) {
        statusCallback.onLoading(true);

        DataCallbacks.getUserData(params.key, new OnDataGetCallback<ItemsUser>() {
            @Override
            public void onDataGet(ItemsUser userItem) {
                statusCallback.onLoading(false);

                Integer nextPageKey = userItem.getTotalPages() > params.key ? params.key + 1 : null;

                callback.onResult(new ArrayList<>(userItem.getUserInfoList()), nextPageKey);
            }

            @Override
            public void onDataGetFailed(String errorMessage) {
                statusCallback.onLoading(false);
                statusCallback.onFailed(errorMessage);
            }
        });
    }
}
