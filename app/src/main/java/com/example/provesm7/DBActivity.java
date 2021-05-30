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
                    int mida = (int) DBActivity.this.getAssets().openFd("cesar.png").getLength();
                    byte[] buffer = new byte[mida];

                    InputStream is = DBActivity.this.getAssets().open("cesar.png");


                    int midaAudio = (int) DBActivity.this.getAssets().openFd("audiosisif.mp3").getLength();
                    byte[] bufferAudio = new byte[midaAudio];

                    InputStream isAudio = DBActivity.this.getAssets().open("audiosisif.mp3");
                    isAudio.read(bufferAudio);
                    //Llegim el contingut i tanquem el buffer.
                    is.read(buffer);
                    is.close();

                    Escultura onades = new Escultura("Sisif", "Material: Pedra calissa de ColmenarAlçada: 180 cm / Amplada 190 cm.Pes: 8.000 kg.", "Any: 1975",Blob.fromBytes(buffer),Blob.fromBytes(bufferAudio));
                   Artista joan = new Artista("Cèsar", "García", "Montaña", "1928", "2000", Blob.fromBytes(buffer), Blob.fromBytes(buffer), "Nascut a el 1928 a Vegadeo (Astúries)Va estudiar a la Escuela Superior de Bellas Artes " +
                           "de Madrid.Posteriorment, va residir a Itàlia, des d’on, enconstant formació, va fer viatges " +
                           "d’estudis peraquell país, Grècia, França, Bèlgica, Holanda,Alemanya, Àustria i Anglaterra.Va " +
                           "guanyar nombrosos premis i guardons i hafet exposicions, individuals i col·lectives arreudel món." +
                           "A partir del 1960 passà a viure a Madrid, oninstal·là el seu taller, i on morí l’any 2000." +
                           "\n--------------------------------------------\n" +
                           "És un escultor d’arrels classicitzants, però queamb el pas del temps ha anat evolucionant, através de l’experimentació en materials,formats i volums, cap a l’abstracció, desdibuixant les formes fins a fer-les de vegades difícils de reconèixer-les.Ha treballat principalment amb la pedra i elmetall, sobretot bronze.");
                    db.collection("artistes").
                            document("Cèsar").
                            set(joan).
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

}