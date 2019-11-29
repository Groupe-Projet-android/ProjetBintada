package com.example.bintada;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactSqlite extends SQLiteOpenHelper {

    private static final String TABLE_CONTACT   = "contact";
    private static final String COL_ID          = "id";
    private static final String COL_NOM         = "nom";
    private static final String COL_PRENOM      = "prenom";
    private static final String COL_SURNOM      = "surnom";
    private static final String COL_NUMERO      = "numero";

    private static final String CREATE_BDD      = "CREATE TABLE " + TABLE_CONTACT + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NOM + " TEXT NOT NULL, "
            + COL_PRENOM + " TEXT NOT NULL, " + COL_SURNOM + " TEXT NOT NULL, " + COL_NUMERO + " TEXT NOT NULL);";

    public ContactSqlite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_CONTACT + ";");
        onCreate(db);
    }
}
