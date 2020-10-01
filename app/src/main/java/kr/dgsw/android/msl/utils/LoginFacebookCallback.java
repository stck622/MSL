package kr.dgsw.android.msl.utils;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;

import kr.dgsw.android.msl.views.MainView;

public class LoginFacebookCallback implements FacebookCallback {

    Activity activity;

    public LoginFacebookCallback(Activity activity){
        this.activity = activity;
    }

    @Override
    public void onSuccess(Object o) {
        Intent intent = new Intent(activity, MainView.class);
        activity.startActivity(intent);
        Toast.makeText(activity, "성공", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel() {
        Toast.makeText(activity, "캔슬", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(FacebookException error) {
        Toast.makeText(activity, "에러", Toast.LENGTH_SHORT).show();
    }
}
