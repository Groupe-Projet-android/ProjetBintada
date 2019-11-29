package com.example.bintada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bintada.data.Contact;
import com.example.bintada.data.ContactCread;
import com.example.bintada.data.ContactSqlite;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NouveauContact extends AppCompatActivity {

    private EditText mNom;
    private EditText mPrenom;
    private EditText mSurnom;
    private EditText mNumero;
    private Button   mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_contact);

        final ContactCread contactCread = new ContactCread(this);

        mNom    = (EditText) findViewById(R.id.nomContact);
        mPrenom = (EditText) findViewById(R.id.prenomContact);
        mSurnom = (EditText) findViewById(R.id.surnomContact);
        mNumero = (EditText) findViewById(R.id.numeroContact);
        mSubmit = (Button) findViewById(R.id.submitContact);

        //mSubmit.setEnabled(false);

        mNom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //mSubmit.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPrenom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSubmit.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSurnom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSubmit.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNumero.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mSubmit.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
    }
}
