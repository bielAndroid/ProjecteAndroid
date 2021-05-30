package com.example.provesm7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ArtistaDetall extends AppCompatActivity {

    ImageView imatgeArGran;
    TextView tvNom, tvAny, tvDescripcio;

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artista_detall);

        imatgeArGran = findViewById(R.id.imatgeArGran);
        tvNom = findViewById(R.id.tvNom);
        tvAny = findViewById(R.id.tvAny);
        tvDescripcio = findViewById(R.id.tvDescripcio);


        db = FirebaseFirestore.getInstance();
        Intent intent = getIntent();

        String nom = intent.getStringExtra("As");

        Log.d("Nom",nom);
        Consultar(nom);

    }
    public void Consultar(String s){
        db.collection("artistes").document(s).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Artista a = documentSnapshot.toObject(Artista.class);

                Bitmap bitmap = BitmapFactory.decodeByteArray(a.getFotografia().toBytes(), 0, a.getFotografia().toBytes().length);
                imatgeArGran.setImageBitmap(bitmap);
                tvNom.setText(a.getNom() + " " + a.getCognom() + " "+ a.getCognom2());
                tvAny.setText(a.getDataNaixement() + " - " + a.getDataMort());
                tvDescripcio.setText(a.getDescripcio());

            }
        });
    }
}