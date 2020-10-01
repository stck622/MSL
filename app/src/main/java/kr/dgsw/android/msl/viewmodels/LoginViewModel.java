package kr.dgsw.android.msl.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kr.dgsw.android.msl.utils.SingleLiveEvent;

public class LoginViewModel extends ViewModel {

    SingleLiveEvent<Void> loginBtn;

    private MutableLiveData<Integer> res;

    public MutableLiveData<Integer> getRes() {
        if (res == null) {
            res = new MutableLiveData<>(0);
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

