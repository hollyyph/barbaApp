package com.example.contohapp.ui.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.contohapp.CatalogChoose1;
import com.example.contohapp.R;
import com.example.contohapp.ReserveHome;

import org.jetbrains.annotations.NotNull;

public class CatalogFragment extends Fragment {

    private CatalogViewModel catalogViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        catalogViewModel =
                new ViewModelProvider(this).get(CatalogViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalog, container, false);

        final TextView textView = root.findViewById(R.id.text_catalog);

        catalogViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ImageButton jenis1Button = (ImageButton) getView().findViewById(R.id.Catalog_button1);
        ImageButton jenis2Button = (ImageButton) getView().findViewById(R.id.Catalog_button2);
        ImageButton jenis3Button = (ImageButton) getView().findViewById(R.id.Catalog_button3);
        ImageButton jenis4Button = (ImageButton) getView().findViewById(R.id.Catalog_button4);
        ImageButton jenis5Button = (ImageButton) getView().findViewById(R.id.Catalog_button5);
        ImageButton jenis6Button = (ImageButton) getView().findViewById(R.id.Catalog_button6);
        ImageButton jenis7Button = (ImageButton) getView().findViewById(R.id.Catalog_button7);
        ImageButton jenis8Button = (ImageButton) getView().findViewById(R.id.Catalog_button8);

        jenis1Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), CatalogChoose1.class);
                startActivity(intent);
            }
        });
    }
}