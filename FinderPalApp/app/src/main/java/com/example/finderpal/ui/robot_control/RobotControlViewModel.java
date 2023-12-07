package com.example.finderpal.ui.robot_control;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finderpal.MainActivity;
import com.example.finderpal.R;
import com.example.finderpal.sshActivity;

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

    public void initiateSSHConnection(Context context)
    {
        try {
            // Create an intent for sshActivity
            Intent intent = new Intent(context, sshActivity.class);

            String host = "192.168.56.1";
            String port = "22";
            String username = "nzpan";
            String password = "Razorteethman1!";

            // Pass on data to sshActivity via intent
            intent.putExtra("host", host);
            intent.putExtra("port", port);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            context.startService(intent);

        } catch (ActivityNotFoundException e) {
            // Handle if the activity is not found
            e.printStackTrace();
            // Display an error message or handle the exception as needed
            Log.e("SSHActivityNotFound", "The SSH activity is not found");
            // You can also show a toast or alert dialog to inform the user
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            // Display an error message or handle the exception as needed
            Log.e("SSHConnectionError", "Error while initiating SSH connection");
        }


    }

    public void sendStringOverSSH(String dataToSend) {

        // Send the string over SSH connection
        sshActivity sshActivityInstance = new sshActivity();
        sshActivityInstance.sendStringOverSSH(dataToSend);
    }

    public LiveData<String> getText() {
        return mText;
    }
}