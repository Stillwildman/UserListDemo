package com.vincent.listdemo.ui;

import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.vincent.listdemo.R;
import com.vincent.listdemo.bases.BaseActivity;
import com.vincent.listdemo.callbacks.PagingStatusCallback;
import com.vincent.listdemo.databinding.ActivityMainBinding;
import com.vincent.listdemo.model.ItemsUser;
import com.vincent.listdemo.ui.adapters.UserListAdapter;
import com.vincent.listdemo.utilities.Utility;
import com.vincent.listdemo.viewmodel.UserViewModel;

public class UiMainActivity extends BaseActivity<ActivityMainBinding> implements SwipeRefreshLayout.OnRefreshListener, PagingStatusCallback {

    private UserViewModel viewModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        initSwipeRefresher();
        initRecycler();
        initViewModel();
    }

    private void initSwipeRefresher() {
        ((SwipeRefreshLayout) mBinding.getRoot()).setOnRefreshListener(this);

        ((SwipeRefreshLayout) mBinding.getRoot()).setColorSchemeResources(
                R.color.md_green_500, R.color.md_amber_400,
                R.color.md_light_blue_A700, R.color.md_red_500);
    }

    private void initRecycler() {
        mBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        mBinding.recycler.setAdapter(new UserListAdapter(new DiffUtil.ItemCallback<ItemsUser.UserInfo>() {
            @Override
            public boolean areItemsTheSame(@NonNull ItemsUser.UserInfo oldItem, @NonNull ItemsUser.UserInfo newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull ItemsUser.UserInfo oldItem, @NonNull ItemsUser.UserInfo newItem) {
                return oldItem.getId() == newItem.getId() && oldItem.getFullName().equals(newItem.getFullName());
            }
        }));
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.setStatusCallback(this);

        observeStatus();

        getUserData();
    }

    private void observeStatus() {
        viewModel.liveLoadingStatus.observe(this, isRefreshing -> mBinding.setIsRefreshing(isRefreshing));
        viewModel.liveErrorMessage.observe(this, Utility::toastShort);
    }

    public void getUserData() {
        viewModel.getLiveUserList().observe(this, userInfoList -> getUserListAdapter().submitList(userInfoList));
    }

    @Override
    public void onLoading(boolean isLoading) {
        viewModel.liveLoadingStatus.postValue(isLoading);
    }

    @Override
    public void onFailed(String errorMessage) {
        Log.e(TAG, errorMessage);
        viewModel.liveErrorMessage.setValue(errorMessage);
    }

    @Override
    public void onRefresh() {
        getUserData();
    }

    private UserListAdapter getUserListAdapter() {
        return (UserListAdapter) mBinding.recycler.getAdapter();
    }
}
