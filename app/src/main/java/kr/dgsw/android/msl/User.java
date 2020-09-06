package kr.dgsw.android.msl;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import kotlin.jvm.JvmStatic;

public class User {

    private ObservableField<String> firstName = new ObservableField<>();
    private ObservableField<String> lastName = new ObservableField<>();

    private String profile;

    public User(String firstName, String lastName, String profile) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.profile = profile;
    }

    public ObservableField<String> getFirstName() {
        return this.firstName;
    }

    public ObservableField<String> getLastName() {
        return this.lastName;
    }

    public void buttonClickEvent() {
        String tmp = firstName.get();
        firstName.set(lastName.get());
        lastName.set(tmp);
        Log.e(String.valueOf(lastName), String.valueOf(tmp));
    }

    @JvmStatic
    @BindingAdapter("setImage")
    public static void setImaged(ImageView view, String profile) {


        Glide.with(view.getContext().getApplicationContext())
                .load(R.drawable.loginimage)
                .apply(new RequestOptions().centerCrop().placeholder(R.drawable.com_facebook_auth_dialog_background).error(R.drawable.com_facebook_auth_dialog_cancel_background))
                .into(view);

        view.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);

    }

}

