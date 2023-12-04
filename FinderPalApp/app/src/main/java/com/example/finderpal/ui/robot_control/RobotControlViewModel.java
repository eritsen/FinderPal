package com.example.finderpal.ui.robot_control;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RobotControlViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RobotControlViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the robot control fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}