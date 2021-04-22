package com.example.provesm7;

import com.google.firebase.firestore.Blob;

public class Escultura {
    private String nom;
    private String descripcio;
    private String dataCreacio;
    private Blob fotografia = Blob.fromBytes(new byte[]{});
    private Blob audio = Blob.fromBytes(new byte[]{});

    //Constructor
    public Escultura(String nom, String descripcio, String dataCreacio){
        this.nom = nom;
        this.descripcio = descripcio;
        this.dataCreacio = dataCreacio;
    }
    //Getters i setters.
    public String getNom(){
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getDataCreacio() {
        return dataCreacio;
    }

    public void setDataCreacio(String dataCreacio) {
        this.dataCreacio = dataCreacio;
    }
}
