package com.example.finderpal.ui.robot_control;

import android.os.Bundle;
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
            public void onClick(View v)
            {
                viewModel.sendStringOverSSH("Forward");
                RobotControlViewModel.onForwardButtonClick();
            }
        });

        backwardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                viewModel.sendStringOverSSH("Backwards");
                RobotControlViewModel.onBackwardButtonClick();
            }
        });

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                viewModel.sendStringOverSSH("Left");
                RobotControlViewModel.onLeftButtonClick();
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                viewModel.sendStringOverSSH("Right");
                RobotControlViewModel.onRightButtonClick();
            }
        });

        manualControlDisableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
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
            public void onClick(View v)
            {
                forwardButton.setEnabled(true);
                backwardsButton.setEnabled(true);
                leftButton.setEnabled(true);
                rightButton.setEnabled(true);

                RobotControlViewModel viewModel = new ViewModelProvider(requireActivity()).get(RobotControlViewModel.class);
                viewModel.initiateSSHConnection(requireContext());
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
}