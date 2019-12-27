package com.example.rudapplication.ui.catalogo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.rudapplication.R;
import com.example.rudapplication.api.SezioniAPI;
import com.example.rudapplication.model.Sezione;
import com.example.rudapplication.utils.SezioniRecyclerViewAdapter;
import com.example.rudapplication.utils.RetrofitUtil;


public class CatalogoFragment extends Fragment {

    private CatalogoViewModel catalogoViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RetrofitUtil retrofitUtil;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        catalogoViewModel =
                ViewModelProviders.of(this).get(CatalogoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalogo, container, false);

        retrofitUtil = RetrofitUtil.getInstance();
        mRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view_sezioni);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        SezioniAPI sezioniAPI = retrofitUtil.getRetrofit().create(SezioniAPI.class);
        Call<List<Sezione>> call2 = sezioniAPI.getSezioni();
        call2.enqueue(new Callback<List<Sezione>>() {
            @Override
            public void onResponse(Call<List<Sezione>> call, Response<List<Sezione>> response) {

                List<Sezione> sezioneList = response.body();

                mAdapter = new SezioniRecyclerViewAdapter(sezioneList, getActivity());

                mRecyclerView.setAdapter(mAdapter);

                // Code to Add an item with default animation
                //((SezioniRecyclerViewAdapter) mAdapter).addItem(obj, index);

                // Code to remove an item with default animation
                //((SezioniRecyclerViewAdapter) mAdapter).deleteItem(index);
            }

            @Override
            public void onFailure(Call<List<Sezione>> call, Throwable t) {
                call.cancel();
            }
        });

        return root;
    }
}