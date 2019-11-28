package com.example.bintada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class ListeContact extends AppCompatActivity {

    ListView mListView;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent", "Gerard", "Hugo",
            "Ingrid", "Jonathan", "Kevin", "Logan", "Matthieu", "Noémie", "Olivia", "Phillipe"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_contact);

        mListView   = (ListView) findViewById(R.id.listview);

        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(ListeContact.this, R.layout.activity_liste_contact, prenoms);
        mListView.setAdapter(adapter);

    }
}
