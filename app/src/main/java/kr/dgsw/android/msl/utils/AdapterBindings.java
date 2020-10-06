package kr.dgsw.android.msl.utils;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import kotlin.jvm.JvmStatic;
import kr.dgsw.android.msl.R;

public class AdapterBindings {

    @BindingAdapter("setBackgroundImage")
    public static void setBackgroundImage(ImageView view, int res) {
        Glide.with(view.getContext().getApplicationContext())
                .load(res)
                .apply(new RequestOptions().centerCrop().placeholder(R.drawable.com_facebook_auth_dialog_background).error(R.drawable.com_facebook_auth_dialog_cancel_background))
                .into(view);
    }

    @BindingAdapter("storeListItem")
    public static void storeListItem(RecyclerView recyclerView, ObservableArrayList<StoreListItem> item) {
        StoreListAdapter adapter = (StoreListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItem(item);
        }
    }

    @BindingAdapter("setStar")
    public static void setStar(TextView textView, StoreListItem item) {
        if(item.getStarCounter() != 0) {
            long result = item.getStarTotal() / item.getStarCounter();
            textView.setText(String.valueOf(result));
        } else {
            textView.setText(String.valueOf(0));
        }
    }

    @BindingAdapter("setThumbnail")
    public static void setThumbnail(ImageView view, String path) {
        Glide.with(view.getContext().getApplicationContext())
                .load(path)
                .transform(new RoundedCorners(10))
                .apply(new RequestOptions().centerCrop().placeholder(R.drawable.com_facebook_auth_dialog_background).error(R.drawable.com_facebook_auth_dialog_cancel_background))
                .into(view);
    }


}
