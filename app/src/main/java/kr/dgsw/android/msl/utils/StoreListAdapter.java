package kr.dgsw.android.msl.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kr.dgsw.android.msl.databinding.StoreListItemBinding;
import kr.dgsw.android.msl.views.MainView;
import kr.dgsw.android.msl.views.StoreInfoView;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListHolder> {

    ObservableArrayList<StoreListItem> items;

    public StoreListAdapter(ObservableArrayList<StoreListItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public StoreListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StoreListItemBinding binding = StoreListItemBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new StoreListHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreListHolder holder, int position) {
        StoreListItem item = items.get(position);
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

    void setItem(ObservableArrayList<StoreListItem> items) {
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
