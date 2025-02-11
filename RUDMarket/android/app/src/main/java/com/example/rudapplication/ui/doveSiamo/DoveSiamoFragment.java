package com.example.rudapplication.ui.doveSiamo;

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

public class DoveSiamoFragment extends Fragment {

    private DoveSiamoViewModel doveSiamoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        doveSiamoViewModel =
                ViewModelProviders.of(this).get(DoveSiamoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dovesiamo, container, false);
        final TextView textView = root.findViewById(R.id.text_doveSiamo);
        doveSiamoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}