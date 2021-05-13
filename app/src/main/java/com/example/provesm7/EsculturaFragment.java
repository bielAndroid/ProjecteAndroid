package com.example.provesm7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class EsculturaFragment extends Fragment {

    RecyclerView rv;
    RecyclerView.LayoutManager esculturesLayout;
    FirebaseFirestore db;
    public static EsculturaAdapter adapterEscultura;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.escultura_fragment,container,false);

        rv = (RecyclerView) root.findViewById(R.id.rvEscultura);
        db = FirebaseFirestore.getInstance();

        esculturesLayout = new GridLayoutManager(EsculturaFragment.this.getContext(),2);

        rv.setLayoutManager(esculturesLayout);

        Query consulta = db.collection("escultures").limit(50);

        FirestoreRecyclerOptions<Escultura> opcions = new FirestoreRecyclerOptions.
                Builder<Escultura>()
                .setQuery(consulta,Escultura.class)
                .build();

        adapterEscultura = new EsculturaAdapter(opcions);

        rv.setAdapter(adapterEscultura);
        adapterEscultura.startListening();

        return root;
    }
}
