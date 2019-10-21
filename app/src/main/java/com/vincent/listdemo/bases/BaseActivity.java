package com.vincent.listdemo.bases;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<bindingView extends ViewDataBinding> extends AppCompatActivity {

    protected final String TAG = getClass().getSimpleName();

    protected abstract int getLayoutId();

    protected abstract void init();

    protected bindingView mBinding;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, getLayoutId());

        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart!!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume!!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop!!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy!!");
    }
}
