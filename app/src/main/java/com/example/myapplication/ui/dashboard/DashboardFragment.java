package com.example.myapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final ProgressBar progressBar = root.findViewById(R.id.determinateBar);
        final Switch aSwitch = root.findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // do something, the isChecked will be
            // true if the switch is in the On position
            if(isChecked) {
                //AWAY Mode call the api accordingly
                settingTextValue(root, "20$ \n Used today");
            } else {
                settingTextValue(root, "540G \n Used today");
            }
        });
        settingTextValue(root, "540 G \n Used today");
        progressBar.setClickable(true);
        progressBar.setMax(100);
        progressBar.setProgress(75);
        return root;
    }

    private void settingTextValue(View root, String content) {
        final TextView textView = root.findViewById(R.id.text_view_progress);
        textView.setText(content);
    }
}