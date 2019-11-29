package com.example.bintada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button btnCreer;
    Button btnLister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnCreer = (Button) findViewById(R.id.btncreate);
        btnLister= (Button) findViewById(R.id.btnlist);

        btnCreer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(Main2Activity.this, NouveauContact.class);
                startActivity(intentCreate);
            }
        });

        btnLister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentList = new Intent(Main2Activity.this, ListeContact.class);
                startActivity(intentList);
            }
        });
    }
}
