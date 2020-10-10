package kr.dgsw.android.msl.utils;

import androidx.recyclerview.widget.RecyclerView;

import kr.dgsw.android.msl.databinding.StoreReviewItemBinding;

public class ReviewListHolder extends RecyclerView.ViewHolder {

    StoreReviewItemBinding binding;

    ReviewListHolder(StoreReviewItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Review item) {
        binding.setItemViewModel(item);
    }

}
