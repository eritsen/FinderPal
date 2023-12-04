package com.example.finderpal.ui.login;

import android.view.View;
import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.finderpal.MainActivity;
import com.example.finderpal.R;

public class LoginViewModel extends ViewModel {

    //private final MutableLiveData<String> mText;
    private String enteredUsername;
    private String enteredPassword;

    public LoginViewModel() {

        //if (enteredPassword == "password" && enteredUsername == "username");
        //{

        //}
        //mText = new MutableLiveData<>();
        //mText.setValue("This is login fragment");
    }

    //public LiveData<String> getText() {
        //return mText;
    //}
}
