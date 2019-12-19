package com.example.rudapplication.ui.catalogo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.rudapplication.R;

public class CatalogoFragment extends Fragment {

    private CatalogoViewModel catalogoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        catalogoViewModel =
                ViewModelProviders.of(this).get(CatalogoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalogo, container, false);
        final TextView textView = root.findViewById(R.id.text_catalogo);
        catalogoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}