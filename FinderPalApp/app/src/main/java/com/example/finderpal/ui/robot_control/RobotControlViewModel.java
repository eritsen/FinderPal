package com.example.finderpal.ui.robot_control;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finderpal.R;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class RobotControlViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RobotControlViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is the robot control fragment");
    }

    public static void onForwardButtonClick()
    {

        Log.i("Forward button","forward button pressed");
    }
    public static void onBackwardButtonClick()
    {
        Log.i("Backward button","backward button pressed");
    }

    public static void onRightButtonClick()
    {
        Log.i("Right button","right button pressed");
    }
    public static void onLeftButtonClick()
    {
        Log.i("Left button","left button pressed");
    }

    public static void onManualControlEnableButtonClick()
    {
        Log.i("Manual Control Enable button","Manual Control Enable button pressed");
    }

    public static void onManualControlDisableButtonClick()
    {
        Log.i("Manual Control Disable button","Manual Control Disable button pressed");
    }

    public static void doPutRequest()
    {
        //performs http put request to send data to the /resource endpoint on the localhost server
        URL url = null;
        try {
            url = new URL("http://localhost/resource");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection httpCon = null;
        try {
            httpCon = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        httpCon.setDoOutput(true);
        try {
            httpCon.setRequestMethod("PUT");
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }
        OutputStreamWriter out = null;
        try {
            out = new OutputStreamWriter(
                    httpCon.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            out.write("Resource content");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            httpCon.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public LiveData<String> getText() {
        return mText;
    }
}