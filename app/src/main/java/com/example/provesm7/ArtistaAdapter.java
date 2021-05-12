package com.example.provesm7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ArtistaAdapter extends FirestoreRecyclerAdapter<Artista, ArtistaAdapter.ArtistaHolder> {


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
        if(holder.nomArtista == null){
            Log.d("NULL","ES NULL");
        }
        else {
            holder.nomArtista.setText(model.getNom());
            holder.linksEscultures.setText("");
            Bitmap bitmap = BitmapFactory.decodeByteArray(model.getFotografia().toBytes(), 0, model.getFotografia().toBytes().length);
            holder.imatgeArtista.setImageBitmap(bitmap);
        }
    }

    @NonNull
    @Override
    public ArtistaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.artista_fragment,parent,false);
        return new ArtistaHolder(vista);
    }
    public String getKey(int pos){
        return super.getSnapshots().getSnapshot(pos).getId();
    }


}