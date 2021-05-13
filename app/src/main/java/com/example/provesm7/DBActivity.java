package com.example.provesm7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.io.InputStream;

public class DBActivity extends AppCompatActivity {

    Button btInserir;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b);

        //Obtenim el botó que tenim en la pantalla
        btInserir = findViewById(R.id.btInserir);

        //Obtenim una instància d'accés a la base de dades FireStore.
        db = FirebaseFirestore.getInstance();

        //onCLick
        btInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int mida = (int) DBActivity.this.getAssets().openFd("onades.png").getLength();
                    byte[] buffer = new byte[mida];

                    InputStream is = DBActivity.this.getAssets().open("onades.png");


                    int midaAudio = (int) DBActivity.this.getAssets().openFd("audiosisif.mp3").getLength();
                    byte[] bufferAudio = new byte[midaAudio];

                    InputStream isAudio = DBActivity.this.getAssets().open("audiosisif.mp3");
                    isAudio.read(bufferAudio);
                    //Llegim el contingut i tanquem el buffer.
                    is.read(buffer);
                    is.close();

                    Escultura onades = new Escultura("Ballant amb les onades", "Material: Pedra d'Ulldecona\n" +
                            "Alçada: 280 cm / Amplada 140 cm.\n" +
                            "Pes: 7.500 kg.\n", "Any: 1975",Blob.fromBytes(buffer),Blob.fromBytes(bufferAudio));
//                    Artista joan = new Artista("Joan", "Serafini", "Masdeu", "1931", "2017", Blob.fromBytes(buffer), Blob.fromBytes(buffer), "Nascut a Valls (l’Alt Camp) el 1931, prengué contacte amb l’escultura a les\n" +
//                            "classes d’art de l’Escola del Treball de la seva vila natal; després d’uns primers anys de cursar dibuix, pintura i escultura amb professors locals, els\n" +
//                            "primers aprenentatges en l’escultura li arribaren de les mans del mestre\n" +
//                            "escultor Josep Busquets, al costat del qual treballà durant 7 anys en la restauració del retaule major de Sant Joan de Valls, època en què s’integrà en\n" +
//                            "el grup Un nus, format per escultors de l’Alt Camp.\n" +
//                            "Participà en nombroses exposicions, fins que l’any 1954 es traslladà a Barcelona, sempre sota l’empara del seu mestre, i completà la seva formació\n" +
//                            "artística en el Cercle Artístic de Sant Lluc. Morí a Valls el 2017.");
                    db.collection("escultures").
                            document("133").
                            set(onades).
                            addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void v) {
                                    Toast.makeText(DBActivity.this, "Inserció realitzada correctament.", Toast.LENGTH_LONG).show();
                                }
                            });

                }
                catch(IOException io){
                    //Toast.makeText(this,"No es pot iniciar l'activitat",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public void ConsultarArtistes(){
        db.collection("artistes")
                .document("")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()) {
                            Artista artistaActual = documentSnapshot.toObject(Artista.class);
                            Toast.makeText(DBActivity.this, "Objecte rebut: " + artistaActual.getNom(), Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }
}