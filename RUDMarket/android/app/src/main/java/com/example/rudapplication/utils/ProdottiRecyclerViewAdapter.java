package com.example.rudapplication.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rudapplication.R;
import com.example.rudapplication.model.Prodotto;

import java.util.List;
import java.util.Map;

public class ProdottiRecyclerViewAdapter extends RecyclerView
        .Adapter<ProdottiRecyclerViewAdapter
        .DataObjectHolder> {

    private List<Prodotto> mDataset;
    private Map<Long, byte[]> imagesMap;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        TextView nome, marca, prezzo;
        ImageView imageView;

        public DataObjectHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textNomeProdotto);
            marca = itemView.findViewById(R.id.textMarcaProdotto);
            prezzo = itemView.findViewById(R.id.textPrezzoProdotto);
            imageView = itemView.findViewById(R.id.imageProdotto);
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

    public ProdottiRecyclerViewAdapter(List<Prodotto> myDataset, Map<Long, byte[]> imagesMap) {
        mDataset = myDataset;
        this.imagesMap = imagesMap;
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

        Long idProdotto = mDataset.get(position).getId();
        byte[] bytes = imagesMap.get(idProdotto);
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        holder.imageView.setImageBitmap(bmp);
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
