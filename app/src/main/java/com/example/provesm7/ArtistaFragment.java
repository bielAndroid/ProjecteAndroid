package com.example.provesm7;

import android.appwidget.AppWidgetHostView;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ArtistaFragment extends Fragment {

    RecyclerView rvArtista;
    RecyclerView.LayoutManager artistesLayout;
    FirebaseFirestore db;
    public static ArtistaAdapter artistaAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.artista_fragment,container,false);

        rvArtista = (RecyclerView) root.findViewById(R.id.rvArtista);
        db = FirebaseFirestore.getInstance();

        artistesLayout = new LinearLayoutManager(ArtistaFragment.this.getContext());

            //Posem el Layout al recycler.
            rvArtista.setLayoutManager(artistesLayout);
            //Obtenim la consulta.
            Query consulta = db.collection("artistes").limit(50);

            FirestoreRecyclerOptions<Artista> opcions = new FirestoreRecyclerOptions
                    .Builder<Artista>()
                    .setQuery(consulta, Artista.class)
                    .build();


            //Creem l'objecte adapter
            artistaAdapter = new ArtistaAdapter(opcions);
            //Posem l'adapter al recycler.
            rvArtista.setAdapter(artistaAdapter);
            artistaAdapter.startListening();
        return root;
    }
}