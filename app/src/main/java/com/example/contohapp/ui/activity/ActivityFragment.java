package com.example.contohapp.ui.activity;

import android.content.Intent;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contohapp.ActivityAdapter;
import com.example.contohapp.OrderModel;
import com.example.contohapp.R;
import com.example.contohapp.ViewConfirmed;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityFragment extends Fragment {

    private ActivityViewModel activityViewModel;
    private LinearLayout l;
    private RecyclerView recyclerView;
    private String idActivity;
    private ArrayList<OrderModel> arrOrder;
    public static final String CHOSEN_ID_ACTIVITY = "com.example.contohapp.cidactivity";

    private static final String[] activityIds = new String[] {"1","2","3","4"};
    private static final String[] activityNames = new String[] {"John", "July", "June", "Jill"};
    private static final String[] activityDates = new String[] {"23 Agustus 2020", "4 September 2020", "18 Desember 2020", "3 Maret 2021"};
    private static final String[] activityStatuses = new String[] {"Done", "Done", "Done", "Done"};


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

        //import data orders dari database
        //code

        recyclerView = recyclerView.findViewById(R.id.Activity_recyclerview);
        ActivityAdapter activityAdapter = new ActivityAdapter(activityIds, activityNames, activityDates, activityStatuses, new ActivityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                idActivity = item;
            }
        });
        recyclerView.setAdapter(activityAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        l = (LinearLayout) root.findViewById(R.id.loop_layout);

        // kasi code buat loop bikin layout > udh recycler view

        return root;
    }

    public void chooseActivity(View view){
        Intent intent = new Intent(getActivity(), ViewConfirmed.class);
        intent.putExtra(CHOSEN_ID_ACTIVITY, idActivity);
        startActivity(intent);
    }

}