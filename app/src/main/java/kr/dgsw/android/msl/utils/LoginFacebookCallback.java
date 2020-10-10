package kr.dgsw.android.msl.utils;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.LoginStatusCallback;

import com.google.firebase.auth.FirebaseAuth;


public class LoginFacebookCallback implements FacebookCallback, LoginStatusCallback {

    Activity activity;
    private FirebaseAuth mAuth;

    public void changePage(String toast){
        Toast.makeText(activity, toast, Toast.LENGTH_SHORT).show();
        FacebookUtil.handleFacebookAccessToken(activity, AccessToken.getCurrentAccessToken());
    }

    public LoginFacebookCallback(Activity activity){
        this.activity = activity;
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onSuccess(Object o) {
        changePage("로그인 성공");
    }

    @Override
    public void onCancel() {
        Toast.makeText(activity, "캔슬", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(FacebookException error) {
        Toast.makeText(activity, "에러", Toast.LENGTH_SHORT).show();
        Log.e("e",error.toString());
    }

    @Override
    public void onCompleted(AccessToken accessToken) {
        changePage("자동로그인 성공");
    }

    @Override
    public void onFailure() {
        Toast.makeText(activity, "자동로그인 실패", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Exception exception) {
        Toast.makeText(activity, "자동로그인 에러", Toast.LENGTH_SHORT).show();
        Log.e("e",exception.toString());
    }
}
