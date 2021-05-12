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

                    //Llegim el contingut i tanquem el buffer.
                    is.read(buffer);
                    is.close();

                    Artista cesar = new Artista("Cèsar", "Montaña", "García", "1928", "2000", Blob.fromBytes(buffer), Blob.fromBytes(buffer), "Nascut a el 1928 a Vegadeo (Astúries)\n" +
                            "Va estudiar a la Escuela Superior de Bellas\n" +
                            "Artes de Madrid.\n" +
                            "Posteriorment, va residir a Itàlia, des d’on, en\n" +
                            "constant formació, va fer viatges d’estudis per\n" +
                            "aquell país, Grècia, França, Bèlgica, Holanda,\n" +
                            "Alemanya, Àustria i Anglaterra.\n" +
                            "Va guanyar nombrosos premis i guardons i ha\n" +
                            "fet exposicions, individuals i col·lectives arreu\n" +
                            "del món.\n" +
                            "A partir del 1960 passà a viure a Madrid, on\n" +
                            "instal·là el seu taller, i on morí l’any 2000.\n" +
                            "--------------------------------------------\n" +
                            "És un escultor d’arrels classicitzants, però que\n" +
                            "amb el pas del temps ha anat evolucionant, a\n" +
                            "través de l’experimentació en materials,\n" +
                            "formats i volums, cap a l’abstracció, desdibuixant les formes fins a fer-les de vegades\n" +
                            "difícils de reconèixer-les.\n" +
                            "Ha treballat principalment amb la pedra i el\n" +
                            "metall, sobretot bronze.");
                    db.collection("artistes").
                            document("123").
                            set(cesar).
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