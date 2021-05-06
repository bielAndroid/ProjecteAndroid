package com.example.provesm7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class ArtistaAdapter extends FirestoreRecyclerAdapter<Artista, ArtistaAdapter.ArtistaHolder> {

    private ArrayList<Artista> artistesRecycler;

    public static class ArtistaHolder extends RecyclerView.ViewHolder{
        public View element;
        public ImageView imatgeArtista;
        public TextView nomArtista;
        public TextView linksEscultures;

        public ArtistaHolder(View itemView){
            super (itemView);
            imatgeArtista = (ImageView) itemView.findViewById(R.id.imatgeArtista);
            nomArtista = (TextView) itemView.findViewById(R.id.tvNom);
            linksEscultures = (TextView) itemView.findViewById(R.id.tvLink);
        }
    }
    public ArtistaAdapter (@NonNull FirestoreRecyclerOptions<Artista> opcions){
        super(opcions);
    }
    @Override
    protected void onBindViewHolder(@NonNull ArtistaAdapter.ArtistaHolder holder, int position, @NonNull Artista model) {
        ArtistaAdapter.PersonalitzaVista(holder,model);
    }

    @NonNull
    @Override
    public ArtistaAdapter.ArtistaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.artista_fragment,parent,false);
        return new ArtistaAdapter.ArtistaHolder(vista);
    }
    public String getKey(int pos){
        return super.getSnapshots().getSnapshot(pos).getId();
    }

    public static void PersonalitzaVista(ArtistaAdapter.ArtistaHolder holder, Artista artista){
        //holder
    }

}