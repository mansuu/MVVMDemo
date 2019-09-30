package com.example.mvvmdemojava.viewmodels;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.mvvmdemojava.models.User;

public class LoginViewModel extends BaseObservable {
    private User user;
    private String successMessage = "Login is successful";
    private String errorMessage = "Email or Password not valid";
    @Bindable
    private String toastMessage = null;

    public LoginViewModel() {
        this.user = new User("","");
    }

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);

    }
    public void setUserEmail(String userEmail){
        user.setUserEmail(userEmail);
        notifyPropertyChanged(BR.userEmail);
    }
    @Bindable
    public String getUserEmail(){
        return user.getUserEmail();
    }

    public void setUserPassword(String userPassword){
        user.setUserPassword(userPassword);
        notifyPropertyChanged(BR.userPassword);
    }
    @Bindable
    public String getUserPassword(){
        return user.getUserPassword();
    }
    public void onLoginClicked(){
        if (isCredentialsValid(getUserEmail(), getUserPassword())){
            setToastMessage(successMessage);
        }
        else{
            setToastMessage(errorMessage);
        }

    }

    public boolean isCredentialsValid(String email, String password){
        if(!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length() > 5){
            return true;

        }
        return false;
    }
}
