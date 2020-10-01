package kr.dgsw.android.msl.utils;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import kr.dgsw.android.msl.databinding.StoreListItemBinding;

public class StoreListHolder extends RecyclerView.ViewHolder {

    StoreListItemBinding binding;

    StoreListHolder(StoreListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(StoreListItem item) {
        binding.setItemViewModel(item);
    }
}
