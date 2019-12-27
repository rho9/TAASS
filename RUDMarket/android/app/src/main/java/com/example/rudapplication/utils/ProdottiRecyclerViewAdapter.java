package com.example.rudapplication.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rudapplication.R;
import com.example.rudapplication.model.Prodotto;

import java.util.List;

public class ProdottiRecyclerViewAdapter extends RecyclerView
        .Adapter<ProdottiRecyclerViewAdapter
        .DataObjectHolder> {

    private List<Prodotto> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        TextView nome, marca, prezzo;

        public DataObjectHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textNomeProdotto);
            marca = itemView.findViewById(R.id.textMarcaProdotto);
            prezzo = itemView.findViewById(R.id.textPrezzoProdotto);
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

    public ProdottiRecyclerViewAdapter(List<Prodotto> myDataset) {
        mDataset = myDataset;
        this.setOnItemClickListener(new MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                System.out.println("Ho cliccato sulla posizione " + position);
            }
        });
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_prodotti, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.nome.setText(mDataset.get(position).getNome());
        holder.marca.setText(mDataset.get(position).getMarca());
        String prezzoString = String.valueOf(mDataset.get(position).getPrezzo());
        if (mDataset.get(position).isAtKg()) {
            prezzoString += " / kg";
        }
        holder.prezzo.setText(prezzoString);
    }

    public void addItem(Prodotto dataObj, int index) {
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
}
