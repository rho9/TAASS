package com.example.rudapplication.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rudapplication.ProdottiActivity;
import com.example.rudapplication.R;
import com.example.rudapplication.api.SezioniAPI;
import com.example.rudapplication.model.Prodotto;
import com.example.rudapplication.model.Sezione;

import java.io.Serializable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SezioniRecyclerViewAdapter extends RecyclerView
        .Adapter<SezioniRecyclerViewAdapter
        .DataObjectHolder> {

    private List<Sezione> mDataset;
    private Context context;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        TextView label;

        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textNomeSezione);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public SezioniRecyclerViewAdapter(List<Sezione> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
        this.setOnItemClickListener(new MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                System.out.println("Ho cliccato sulla sezione " +
                        mDataset.get(position).getId().toString());
                callAndGo(position);
            }
        });
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_sezioni, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.label.setText(mDataset.get(position).getNome());
    }

    public void addItem(Sezione dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

    private void callAndGo(int position) {
        Long idSezione = mDataset.get(position).getId();

        SezioniAPI sezioniAPI = RetrofitUtil.getInstance().getRetrofit().create(SezioniAPI.class);
        Call<List<Prodotto>> call2 = sezioniAPI.getProdottiByIdSezione(idSezione);
        call2.enqueue(new Callback<List<Prodotto>>() {
            @Override
            public void onResponse(Call<List<Prodotto>> call, Response<List<Prodotto>> response) {

                List<Prodotto> prodottoList = response.body();
                Intent intent = new Intent(context, ProdottiActivity.class);
                intent.putExtra("list", (Serializable) prodottoList);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<Prodotto>> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
