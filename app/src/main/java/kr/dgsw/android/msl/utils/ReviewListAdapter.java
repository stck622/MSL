package kr.dgsw.android.msl.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import kr.dgsw.android.msl.databinding.StoreItemBinding;
import kr.dgsw.android.msl.databinding.StoreReviewItemBinding;
import kr.dgsw.android.msl.views.StoreInfoView;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListHolder> {

    ObservableArrayList<Review> items;

    public ReviewListAdapter(ObservableArrayList<Review> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ReviewListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StoreReviewItemBinding binding = StoreReviewItemBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ReviewListHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewListHolder holder, int position) {
        Review item = items.get(position);
        holder.bind(item);
    }

    void setItem(ObservableArrayList<Review> items) {
        if (items == null) {
            return;
        }
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
