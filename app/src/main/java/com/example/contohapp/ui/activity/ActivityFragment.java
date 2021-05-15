package com.example.contohapp.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.contohapp.R;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class ActivityFragment extends Fragment {

    private ActivityViewModel activityViewModel;
    private LinearLayout l;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        activityViewModel =
                new ViewModelProvider(this).get(ActivityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_activity, container, false);
        final TextView textView = root.findViewById(R.id.text_activity);
        activityViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        l = (LinearLayout) root.findViewById(R.id.loop_layout);

        for (int i = 1; i< 5; i++){
            String angka = "Ke- "+ i;
            LinearLayout lv = (LinearLayout) root.findViewById(R.id.loop_layout_activity);

            l.addView(lv);
        }


        // kasi code buat loop bikin layout

        return root;
    }

}