package com.example.bintada;

import androidx.annotation.NonNull;

public class Contact {
    private int id;
    private String nom;
    private String prenom;
    private String surnom;
    private int numero;

    public Contact(){}

    Contact(String nom, String prenom, String surnom, int numero) {
        this.nom    = nom;
        this.prenom = prenom;
        this.surnom = surnom;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @NonNull
    @Override
    public String toString() {
        return "ID : "+id+"\nNom : "+this.nom+"\nPrénom : "+this.prenom+"\nSurnom : "+this.surnom+"\nNuméro : "+this.numero;
    }
}
