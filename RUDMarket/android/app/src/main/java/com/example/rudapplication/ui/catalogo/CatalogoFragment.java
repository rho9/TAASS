package com.example.rudapplication.ui.catalogo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.rudapplication.MainActivity;
import com.example.rudapplication.R;
import com.example.rudapplication.api.SezioniAPI;
import com.example.rudapplication.model.Sezione;

import java.util.ArrayList;

public class CatalogoFragment extends Fragment {

    private CatalogoViewModel catalogoViewModel;
    private ListView catalogoList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        catalogoViewModel =
                ViewModelProviders.of(this).get(CatalogoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_catalogo, container, false);

        catalogoList = (ListView)root.findViewById(R.id.catalogo_list_id);
        ArrayList<String> arrayList = new ArrayList<>();
        final Retrofit retrofit = new Retrofit.Builder()
                /*
                    Questo URL è da inserire se ci si vuole connettere al localhost del proprio
                    PC da una macchina virtuale. Se si prova a sostituire con "localhost", ci si
                    starà riferendo all'indirizzo di loopback dell'emulatore stesso
                 */
                .baseUrl("http://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SezioniAPI sezioniAPI = retrofit.create(SezioniAPI.class);
        Call<List<Sezione>> call2 = sezioniAPI.getSezioni();
        call2.enqueue(new Callback<List<Sezione>>() {
            @Override
            public void onResponse(Call<List<Sezione>> call, Response<List<Sezione>> response) {

                List<Sezione> sezioneList = response.body();
                for(Sezione sezione: sezioneList){
                    arrayList.add(sezione.getNome());
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayList);
                catalogoList.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Sezione>> call, Throwable t) {
                call.cancel();
            }
        });

        return root;
    }
}