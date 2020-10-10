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
import kr.dgsw.android.msl.views.StoreInfoView;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListHolder> {

    ObservableArrayList<Store> items;

    public StoreListAdapter(ObservableArrayList<Store> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public StoreListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StoreItemBinding binding = StoreItemBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new StoreListHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreListHolder holder, int position) {
        Store item = items.get(position);
        holder.bind(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, StoreInfoView.class);
                intent.putExtra("item",item);
                context.startActivity(intent);
            }
        });
    }

    void setItem(ObservableArrayList<Store> items) {
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
