package com.example.provesm7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class EsculturaDetall extends AppCompatActivity {

    ImageView imatgeEscultura;
    TextView tvNomEsc,tvMaterials;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escultura_detall);

        imatgeEscultura = findViewById(R.id.imatgeEsc);
        tvNomEsc = findViewById(R.id.tvNomEsc);
        tvMaterials = findViewById(R.id.tvMaterials);


        db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        String nom = intent.getStringExtra("Es");
        tvMaterials.setText(nom);

        Consultar(nom);
    }
    public void Consultar(String s){
        db.collection("escultures").document(s).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Escultura e = documentSnapshot.toObject(Escultura.class);

                Bitmap bitmap = BitmapFactory.decodeByteArray(e.getFotografia().toBytes(), 0, e.getFotografia().toBytes().length);
                imatgeEscultura.setImageBitmap(bitmap);
                tvNomEsc.setText(e.getNom());
                tvMaterials.setText(e.getDescripcio());
            }
        });
    }
}