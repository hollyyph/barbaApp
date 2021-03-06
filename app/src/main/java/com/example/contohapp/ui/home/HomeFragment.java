package com.example.contohapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.contohapp.R;
import com.example.contohapp.ReserveHome;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
//    private Button reserveButton;
//    private Button callButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        reserveButton = reserveButton.findViewById(R.id.reserve_button);
//        reserveButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
////                ReserveFragment reserveFragment = new ReserveFragment();
////                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
////                transaction.replace(R.id.nav_host_fragment, reserveFragment);
////                transaction.commit();
//                System.out.println("Udah bisa click reverse");
//            }
//        });

//        callButton = new Button();

        final TextView textView = root.findViewById(R.id.text_home);

        //final TextView textView1 = root.findViewById(R.id.text_1);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ImageButton reserveButton = (ImageButton) getView().findViewById(R.id.reserve_button);
        reserveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), ReserveHome.class);
                startActivity(intent);
            }
        });
    }

}