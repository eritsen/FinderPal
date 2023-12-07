package com.example.finderpal.ui.robot_control;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.finderpal.MainActivity;
import com.example.finderpal.R;
import com.example.finderpal.databinding.FragmentRobotControlBinding;
import org.apache.sshd.common.io.PacketWriter;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RobotControlFragment extends Fragment {

    private FragmentRobotControlBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RobotControlViewModel robotcontrolViewModel =
                new ViewModelProvider(this).get(RobotControlViewModel.class);

        binding = FragmentRobotControlBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button manualControlDisableButton = root.findViewById(R.id.manualcontroldisablebutton);
        Button manualControlEnableButton = root.findViewById(R.id.manualcontrolenablebutton);

        Button forwardButton = root.findViewById(R.id.arrowforwardbutton);
        Button backwardsButton = root.findViewById(R.id.arrowbackwardsbutton);
        Button leftButton = root.findViewById(R.id.arrowleftbutton);
        Button rightButton = root.findViewById(R.id.arrowrightbutton);
        RobotControlViewModel viewModel = new ViewModelProvider(requireActivity()).get(RobotControlViewModel.class);

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letterToSend = "w"; // Replace 'd' with the letter you want to send
                HttpRequestSender.SendHttpRequestTask(letterToSend);
                //viewModel.sendStringOverSSH("mkdir Hello");
                RobotControlViewModel.onForwardButtonClick();
            }
        });

        backwardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letterToSend = "s"; // Replace 'd' with the letter you want to send
                HttpRequestSender.SendHttpRequestTask(letterToSend);
                //viewModel.sendStringOverSSH("Backwards");
                RobotControlViewModel.onBackwardButtonClick();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letterToSend = "a"; // Replace 'd' with the letter you want to send
                HttpRequestSender.SendHttpRequestTask(letterToSend);
                //viewModel.sendStringOverSSH("Left");
                RobotControlViewModel.onLeftButtonClick();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String letterToSend = "d"; // Replace 'd' with the letter you want to send
                HttpRequestSender.SendHttpRequestTask(letterToSend);
                //viewModel.sendStringOverSSH("Right");
                RobotControlViewModel.onRightButtonClick();
            }
        });

        manualControlDisableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forwardButton.setEnabled(false);
                backwardsButton.setEnabled(false);
                leftButton.setEnabled(false);
                rightButton.setEnabled(false);

                manualControlEnableButton.setEnabled(true);
                RobotControlViewModel.onManualControlDisableButtonClick();
                manualControlDisableButton.setEnabled(false);
            }
        });

        manualControlEnableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forwardButton.setEnabled(true);
                backwardsButton.setEnabled(true);
                leftButton.setEnabled(true);
                rightButton.setEnabled(true);

                //RobotControlViewModel viewModel = new ViewModelProvider(requireActivity()).get(RobotControlViewModel.class);
                //viewModel.initiateSSHConnection(requireContext());
                manualControlDisableButton.setEnabled(true);
                RobotControlViewModel.onManualControlEnableButtonClick();
                manualControlEnableButton.setEnabled(false);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static class HttpRequestSender {
        private static void SendHttpRequestTask(final String letter) {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {


                        // URL for your HTTP POST request
                        URL url = new URL("http://192.168.1.83:5000/keypress");

                        // Create connection
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                        urlConnection.setRequestMethod("POST");
                        urlConnection.setRequestProperty("Content-Type", "application/json"); // Set content type
                        urlConnection.setDoOutput(true);
                        urlConnection.setChunkedStreamingMode(0);

                        // Data to send in the request
                        String data = "{\"key\": \"" + letter + "\"}";
                        byte[] utf8Bytes = data.getBytes("UTF-8"); // Explicitly encode as UTF-8

                        // Send data
                        try (OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream()))
                        {
                            out.write(utf8Bytes);
                            out.flush();
                        }

                        // Check response code (optional)
                        int responseCode = urlConnection.getResponseCode();

                        if (responseCode == HttpURLConnection.HTTP_OK)
                        {

                            // Successful request
                            Log.d("HTTP_POST_REQUEST", "POST request successful");
                        }

                        else
                        {
                            // Handle error
                            Log.e("HTTP_POST_REQUEST", "POST request failed with response code: " + responseCode);


                            // Disconnect after the request is made
                        }

                        urlConnection.disconnect();

                    }
                    catch (Exception e)
                    {

                        e.printStackTrace();
                        Log.e("HTTP_POST_REQUEST", "Error making POST request: " + e.getMessage());

                    }
                }

            }).start();
        }
    }
}
