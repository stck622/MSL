package kr.dgsw.android.msl.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.LoginStatusCallback;
import com.facebook.login.LoginManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

import kr.dgsw.android.msl.R;
import kr.dgsw.android.msl.databinding.ActivityLoginBinding;
import kr.dgsw.android.msl.utils.FacebookUtil;
import kr.dgsw.android.msl.utils.LoginFacebookCallback;
import kr.dgsw.android.msl.viewmodels.LoginViewModel;

public class LoginView extends AppCompatActivity {

    CallbackManager callbackManager;
    FirebaseAuth mAuth;

    ActivityLoginBinding binding;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLifecycleOwner(this);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getRes().setValue(R.drawable.loginimage);

        mAuth = FirebaseAuth.getInstance();
        callbackManager = CallbackManager.Factory.create();

        LoginFacebookCallback facebookCallback = new LoginFacebookCallback(this);
        LoginManager.getInstance().registerCallback(callbackManager, facebookCallback);
        LoginManager.getInstance().retrieveLoginStatus(this, facebookCallback);

        if(FacebookUtil.isLogin()){
            LoginManager.getInstance().logOut();
        }

        viewModel.getLoginBtn().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(Void aVoid) {
                LoginManager.getInstance().logInWithReadPermissions(LoginView.this, Arrays.asList("public_profile"));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

}

