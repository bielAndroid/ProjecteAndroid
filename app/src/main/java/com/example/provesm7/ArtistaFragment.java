package com.example.provesm7;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;

public class ArtistaFragment extends Fragment {

    RecyclerView rvArtista;
    FirebaseFirestore db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.artista_fragment, container, false);


    }

    public class Artista extends AppCompatActivity{

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
            super.onCreate(savedInstanceState, persistentState);
            rvArtista = (RecyclerView) findViewById(R.id.rvArtista);
            db = FirebaseFirestore.getInstance();

            //FirestoreRecyclerOptions<Artista> opcions = new FirestoreRecyclerOptions.Builder<Artista>().setQuery()
        }
    }
}