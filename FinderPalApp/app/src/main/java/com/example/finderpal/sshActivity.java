package com.example.finderpal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.channel.ClientChannel;
import org.apache.sshd.client.channel.ClientChannelEvent;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.channel.Channel;
import org.apache.sshd.server.forward.AcceptAllForwardingFilter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

public class sshActivity extends AppCompatActivity {

    ClientChannel channel;
    TextView shellOutput;
    String host, username, password;
    Integer port;
    String command;

    public void sshConnection()
    {
        // Get user credentials from indent
        Intent intent = getIntent();
        host = intent.getStringExtra("host");
        port = Integer.parseInt(intent.getStringExtra("port"));
        username = intent.getStringExtra("username");
        password = intent.getStringExtra("password");

        // Command which will be executed
        command = "pwd\n";

        // Setting user.com property manually
        // since isn't set by default in android
        String key = "user.home";
        Context Syscontext;
        Syscontext = getApplicationContext();
        String val = Syscontext.getApplicationInfo().dataDir;
        System.setProperty(key, val);

        // Creating a client instance
        SshClient client = SshClient.setUpDefaultClient();
        client.setForwardingFilter(AcceptAllForwardingFilter.INSTANCE);
        client.start();

        // Starting new thread because network processes
        // can interfere with UI if started in main thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Connection establishment and authentication
                    try (ClientSession session = client.connect(username, host, port).verify(10000).getSession()) {
                        session.addPasswordIdentity(password);
                        session.auth().verify(50000);
                        System.out.println("Connection establihed");

                        // Create a channel to communicate
                        channel = session.createChannel(Channel.CHANNEL_SHELL);
                        System.out.println("Starting shell");

                        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
                        channel.setOut(responseStream);

                        // Open channel
                        channel.open().verify(5, TimeUnit.SECONDS);
                        try (OutputStream pipedIn = channel.getInvertedIn()) {
                            pipedIn.write(command.getBytes());
                            pipedIn.flush();
                        }

                        // Close channel
                        channel.waitFor(EnumSet.of(ClientChannelEvent.CLOSED),
                                TimeUnit.SECONDS.toMillis(5));

                        // Output after converting to string type
                        String responseString = new String(responseStream.toByteArray());
                        System.out.println(responseString);
                        shellOutput.setText(responseString);

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        client.stop();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

    public void sendStringOverSSH(String dataToSend) {
        // ... Your existing code to establish the SSH connection ...

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // ... Your existing code to authenticate and open channel ...

                    // Send the string over the SSH channel
                    try (OutputStream pipedIn = channel.getInvertedIn()) {
                        pipedIn.write(dataToSend.getBytes());
                        pipedIn.flush();
                    }

                    // ... Your existing code to handle response or other actions ...

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


}