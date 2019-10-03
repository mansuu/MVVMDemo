package com.example.mvvmdemojava.viewmodels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.mvvmdemojava.models.User;
import com.example.mvvmdemojava.supportingFiles.AppConstants;
import com.example.mvvmdemojava.supportingFiles.Util;

public class LoginViewModel extends BaseObservable {
    private User user;
    @Bindable
    private String toastMessage = null;

    public LoginViewModel() {
        this.user = new User("","", "");
    }

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);

    }
    public void setUserName(String userName){
        user.setUserName(userName);
        notifyPropertyChanged(BR.userName);
    }
    @Bindable
    public String getUserName(){
        return user.getUserName();
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

    public void setConfirmPassword(String confirmPassword){
        user.setConfirmPassword(confirmPassword);
        notifyPropertyChanged(BR.confirmPassword);
    }
    @Bindable
    public String getConfirmPassword(){
        return user.getConfirmPassword();
    }
    public void onLoginClicked(){
        if(user.getUserName() == null){
            setToastMessage(AppConstants.ALL_FIELDS_MANDATORY);
            return;
        }
        else if(user.getUserEmail() == null){
            setToastMessage(AppConstants.ALL_FIELDS_MANDATORY);
            return;
        }
        else if(user.getUserPassword() == null){
            setToastMessage(AppConstants.ALL_FIELDS_MANDATORY);
            return;
        }
        else if(user.getConfirmPassword() == null){
            setToastMessage(AppConstants.ALL_FIELDS_MANDATORY);
            return;
        }
        if (Util.getInstance().areSame(getUserPassword(),getConfirmPassword())){
            if (!Util.getInstance().isEmailValid(getUserEmail())){
                setToastMessage(AppConstants.INVALID_EMAIL);
            }
            else{
                setToastMessage(AppConstants.ACCOUNT_CREATED_SUCCESSFULLY);
            }
        }
        else{
            setToastMessage(AppConstants.PASSWORD_DONOT_MATCH);
        }


    }

}
