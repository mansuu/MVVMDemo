package com.example.mvvmdemojava.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.mvvmdemojava.R;
import com.example.mvvmdemojava.databinding.ActivityLoginBinding;
import com.example.mvvmdemojava.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginBinding.setViewModel(new LoginViewModel());
        loginBinding.executePendingBindings();
    }
    @BindingAdapter("toastMessage")
    public static void runMe(View view,String toastMessage){
        if(toastMessage == null || toastMessage.isEmpty()){
            return;
        }
        Toast.makeText(view.getContext(), toastMessage, Toast.LENGTH_LONG).show();
    }
}
