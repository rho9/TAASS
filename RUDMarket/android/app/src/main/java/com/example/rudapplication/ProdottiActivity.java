package com.example.rudapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.rudapplication.model.Prodotto;

import com.example.rudapplication.utils.ProdottiRecyclerViewAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdottiActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prodotti);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_prodotti);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Intent intent = getIntent();
        List<Prodotto> prodottoList = (List<Prodotto>) intent.getSerializableExtra("list");

        mAdapter = new ProdottiRecyclerViewAdapter(prodottoList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
