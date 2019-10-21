package com.vincent.listdemo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.vincent.listdemo.callbacks.PagingStatusCallback;
import com.vincent.listdemo.model.ItemsUser;
import com.vincent.listdemo.paging.UserDataRepo;

public class UserViewModel extends ViewModel {

    private PagingStatusCallback statusCallback;

    public final MutableLiveData<Boolean> liveLoadingStatus = new MutableLiveData<>();
    public final MutableLiveData<String> liveErrorMessage = new MutableLiveData<>();

    public void setStatusCallback(PagingStatusCallback statusCallback) {
        this.statusCallback = statusCallback;
    }

    public LiveData<PagedList<ItemsUser.UserInfo>> getLiveUserList() {
        return new UserDataRepo(statusCallback).getUserList();
    }

}
