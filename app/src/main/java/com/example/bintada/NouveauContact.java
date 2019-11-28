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

public class NouveauContact extends AppCompatActivity {

    private EditText mNom;
    private EditText mPrenom;
    private EditText mSurnom;
    private EditText mNumero;
    private Button mSubmit;

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

        mSubmit.setEnabled(false);

        mNom.addTextChangedListener(new TextWatcher() {
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
                /*
                Contact contact = new Contact(
                        mNom.toString(),
                        mPrenom.toString(),
                        mSurnom.toString(),
                        Integer.parseInt(mNumero.toString())
                );
*/
                Contact contact = new Contact(
                        "Medi",
                       "Yann",
                        "Carion",
                        57357598
                );
                /*
                contactCread.open();
                contactCread.insererContact(contact);

                //Contact actucontact = contactCread.listerContactParNom(mSurnom.toStr);

                Toast.makeText(NouveauContact.this, "Carion", Toast.LENGTH_LONG).show();
                contactCread.close();

*/
            }
        });
    }
}
