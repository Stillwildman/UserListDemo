package com.vincent.listdemo.ui.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.vincent.listdemo.R;
import com.vincent.listdemo.bases.BaseBindingRecycler;
import com.vincent.listdemo.databinding.InflateUserRowBinding;
import com.vincent.listdemo.model.ItemsUser;

public class UserListAdapter extends BaseBindingRecycler<ItemsUser.UserInfo, InflateUserRowBinding> {

    private final RequestOptions options;

    public UserListAdapter(@NonNull DiffUtil.ItemCallback<ItemsUser.UserInfo> diffCallback) {
        super(diffCallback);
        options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).centerInside().placeholder(R.drawable.ic_place_holder_circle);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.inflate_user_row;
    }

    @Override
    protected void onBindingViewHolder(RecyclerView.ViewHolder holder, InflateUserRowBinding bindingView, int position) {
        ItemsUser.UserInfo userInfo = getItem(position);

        if (userInfo != null) {
            bindingView.setItem(userInfo);

            Glide.with(holder.itemView)
                    .load(userInfo.getAvatar())
                    .apply(options)
                    .into(bindingView.imageAvatar);
        }
    }

    @Override
    protected void onBindingViewHolder(RecyclerView.ViewHolder holder, InflateUserRowBinding bindingView, int position, Object payload) {

    }
}
