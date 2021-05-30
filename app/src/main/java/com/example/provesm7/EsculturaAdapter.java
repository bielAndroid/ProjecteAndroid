package com.example.provesm7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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


    public class EsculturaHolder extends RecyclerView.ViewHolder{
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
        holder.nomEscultura.setText(model.getNom());
        Bitmap bitmap = BitmapFactory.decodeByteArray(model.getFotografia().toBytes(), 0, model.getFotografia().toBytes().length);
        holder.fotoEscultura.setImageBitmap(bitmap);

        holder.fotoEscultura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),EsculturaDetall.class);
                intent.putExtra("Es",model.getNom());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public EsculturaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_escultura_adapter,parent,false);
        return new EsculturaHolder(vista);
    }
    public String getKey(int pos){
        return super.getSnapshots().getSnapshot(pos).getId();
    }
}