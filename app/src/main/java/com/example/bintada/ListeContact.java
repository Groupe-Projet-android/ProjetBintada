package com.example.bintada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListeContact extends AppCompatActivity {

    Button btnAdd;

    public ContactCread contactCread;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;




    //List<Contact> contactList = new ArrayList<Contact>() {};

/*

    public ListeContact() {
        contactCread = new ContactCread(ListeContact.this);
    }
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_contact);

        List<Contact> contactList = new ArrayList<Contact>() {};/*

        contactList.add(new Contact("medi", "yann", "carion", 1234));
        contactList.add(new Contact("medi", "yann", "carion", 1234));
        contactList.add(new Contact("medi", "yann", "carion", 1234));
*/
        contactCread    = new ContactCread(ListeContact.this);
        contactCread.open();
        contactList     =  contactCread.listerTousContact();

        recyclerView = (RecyclerView) findViewById(R.id.contact_recycler);
        btnAdd = (Button) findViewById(R.id.btnadd);

        layoutManager   =   new LinearLayoutManager(ListeContact.this);
        recyclerView.setLayoutManager(layoutManager);

        ContactAdapter contactAdapter   =    new ContactAdapter(contactList);
        recyclerView.setAdapter(contactAdapter);

        contactCread.close();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(ListeContact.this, NouveauContact.class);
                startActivity(intentCreate);
            }
        });

    }
}
