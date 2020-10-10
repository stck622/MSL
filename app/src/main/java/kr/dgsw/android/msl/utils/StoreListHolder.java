package kr.dgsw.android.msl.utils;

import androidx.recyclerview.widget.RecyclerView;

import kr.dgsw.android.msl.databinding.StoreItemBinding;


public class StoreListHolder extends RecyclerView.ViewHolder {

    StoreItemBinding binding;

    StoreListHolder(StoreItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Store item) {
        binding.setItemViewModel(item);
    }

}
