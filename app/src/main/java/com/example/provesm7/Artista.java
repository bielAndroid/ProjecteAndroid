package com.example.provesm7;

import com.google.firebase.firestore.Blob;

public class Artista {
    private String nom;
    private String cognom;
    private String cognom2;
    private String dataNaixement;
    private String dataMort;
    private String descripcio;
    private Blob fotografia = Blob.fromBytes(new byte[]{});
    private Blob audio = Blob.fromBytes(new byte[]{});

    //Constructor Classe Artista
    public Artista(String nom, String cognom, String cognom2, String dataNaixement, String dataMort, String descripcio){
        this.nom = nom;
        this.cognom = cognom;
        this.cognom2 = cognom2;
        this.dataNaixement = dataNaixement;
        this.dataMort = dataMort;
        this.descripcio = descripcio;
    }

    //Getters i Setters de classe Artista
    public String getNom(){
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCognom() {
        return cognom;
    }
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
    public String getCognom2(){
        return cognom2;
    }
    public void setCognom2(String cognom2){
        this.cognom2 = cognom2;
    }
    public String getDescripcio(){
        return descripcio;
    }
    public void setDescripcio(String descripcio){
        this.descripcio = descripcio;
    }
    public String getDataNaixement(){
        return dataNaixement;
    }
    public void setDataNaixement(String dataNaixement){
        this.dataNaixement = dataNaixement;
    }
    public String getDataMort(){
        return dataMort;
    }
    public void setDataMort(String dataMort){
        this.dataMort = dataMort;
    }

    public Blob getFotografia() {
        return fotografia;
    }

    public void setFotografia(Blob fotografia) {
        this.fotografia = fotografia;
    }
}
