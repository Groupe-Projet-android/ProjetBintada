package com.example.bintada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bintada.Contact;
import com.example.bintada.ContactCread;
import com.example.bintada.ContactSqlite;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NouveauContact extends AppCompatActivity {

    private Button btnList;

    private EditText mNom;
    private EditText mPrenom;
    private EditText mSurnom;
    private EditText mNumero;
    private Button   mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nouveau_contact);

        final ContactCread contactCread = new ContactCread(this);

        mNom    = (EditText) findViewById(R.id.nomContact);
        mPrenom = (EditText) findViewById(R.id.prenomContact);
        mSurnom = (EditText) findViewById(R.id.surnomContact);
        mNumero = (EditText) findViewById(R.id.numeroContact);
        mSubmit = (Button) findViewById(R.id.submitContact);

        btnList = (Button) findViewById(R.id.btnretourlist);

        //mSubmit.setEnabled(false);


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = (String) mNom.getText().toString();
                String prenom = (String) mPrenom.getText().toString();
                String surnom = (String) mSurnom.getText().toString();
                String phone = (String) mNumero.getText().toString();


/*
                Contact contact = new Contact(
                        "Medi",
                       "Yann",
                        "Carion",
                        57357598
                );
*/
                contactCread.open();




                if (!nom.equals("") && !prenom.equals("") && !surnom.equals("") && !phone.equals("")) {
                    int numero = Integer.parseInt(phone);
                    Contact vcontact = contactCread.listerContactParNumero(numero);
                    if (vcontact == null) {


                        Contact contact = new Contact(nom, prenom, surnom, numero);
                        contactCread.insererContact(contact);

                        String messageConfirmation = "Merci Bien, " + surnom + " a bien été enregistré";

                        Toast.makeText(NouveauContact.this, messageConfirmation, Toast.LENGTH_LONG).show();

                        Intent intentList = new Intent(NouveauContact.this, ListeContact.class);
                        startActivity(intentList);
                    } else {
                        String messageErreur = "Le détenteur du numéro " + phone + " existe déja.";

                        Toast.makeText(NouveauContact.this, messageErreur, Toast.LENGTH_LONG).show();


                    }
                } else {
                    String messageErreur = "Tous les champs sont obligatoires, Merci !!!";

                    Toast.makeText(NouveauContact.this, messageErreur, Toast.LENGTH_LONG).show();
                }

                contactCread.close();
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
