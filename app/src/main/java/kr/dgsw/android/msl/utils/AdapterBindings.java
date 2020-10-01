package kr.dgsw.android.msl.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import kotlin.jvm.JvmStatic;
import kr.dgsw.android.msl.R;

public class AdapterBindings {

    @JvmStatic
    @BindingAdapter("setImage")
    public static void setImaged(ImageView view, int res) {
        Glide.with(view.getContext().getApplicationContext())
                .load(res)
                .apply(new RequestOptions().centerCrop().placeholder(R.drawable.com_facebook_auth_dialog_background).error(R.drawable.com_facebook_auth_dialog_cancel_background))
                .into(view);
    }

    @BindingAdapter("item")
    public static void bindItem(RecyclerView recyclerView, ObservableArrayList<StoreListItem> item) {
        StoreListAdapter adapter = (StoreListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItem(item);
        }
    }

}
