package kr.dgsw.android.msl.viewmodels;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.login.LoginManager;

import java.util.Arrays;

import kotlin.jvm.JvmStatic;
import kr.dgsw.android.msl.R;
import kr.dgsw.android.msl.Utils.SingleLiveEvent;

public class LoginViewModel extends ViewModel {

    SingleLiveEvent<Void> loginBtn;

    private MutableLiveData<Integer> res;

    public LoginViewModel(){}

    @JvmStatic
    @BindingAdapter("setImage")
    public static void setImaged(ImageView view, int res) {
        Glide.with(view.getContext().getApplicationContext())
                .load(res)
                .apply(new RequestOptions().centerCrop().placeholder(R.drawable.com_facebook_auth_dialog_background).error(R.drawable.com_facebook_auth_dialog_cancel_background))
                .into(view);
    }

    public MutableLiveData<Integer> getRes() {
        if (res == null) {
            res = new MutableLiveData<Integer>(0);
        }
        return res;
    }

    public SingleLiveEvent<Void> getLoginBtn() {
        if (loginBtn == null) {
            loginBtn = new SingleLiveEvent<Void>();
        }
        return loginBtn;
    }

    public void clickLogin(){
        loginBtn.call();
    }

}

