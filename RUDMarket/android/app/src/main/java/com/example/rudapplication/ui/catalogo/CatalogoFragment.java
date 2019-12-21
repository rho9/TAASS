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

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.rudapplication.MainActivity;
import com.example.rudapplication.R;

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
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayList);
        catalogoList.setAdapter(arrayAdapter);
        /*catalogoList.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Toast.makeText(MainActivity.this, "item "+i+" "+arrayList.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        } );*/

        return root;
    }
}