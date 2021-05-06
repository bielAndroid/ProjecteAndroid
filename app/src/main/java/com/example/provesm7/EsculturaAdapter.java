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

import java.util.ArrayList;

public class EsculturaAdapter extends FirestoreRecyclerAdapter<Escultura, EsculturaAdapter.EsculturaHolder> {

    public ArrayList<Escultura> esculturesRecycler;
    public static class EsculturaHolder extends RecyclerView.ViewHolder{
        public View element;
        public ImageView fotoEscultura;
        public TextView nomEscultura;
        public EsculturaHolder(View itemView) {
            super(itemView);
            fotoEscultura = (ImageView) itemView.findViewById(R.id.imatgeEscultura);
            nomEscultura = (TextView) itemView.findViewById(R.id.nomEscultura);
        }
    }
    public EsculturaAdapter (@NonNull FirestoreRecyclerOptions<Escultura> options){
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull EsculturaAdapter.EsculturaHolder holder, int position, @NonNull Escultura model) {
        EsculturaAdapter.PersonalitzaVista(holder,model);
    }

    @NonNull
    @Override
    public EsculturaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.escultura_fragment,parent,false);
        return new EsculturaAdapter.EsculturaHolder(vista);
    }
    public static void PersonalitzaVista(EsculturaAdapter.EsculturaHolder holder, Escultura artista){
        //holder
    }
}