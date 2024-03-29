package com.example.bintada;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContactCread {
    private static final int VERSION_BDD= 1;
    private static final String BDDNAME = "bdcontact.db";

    private static final String TABLE_CONTACT   = "contact";
    private static final String COL_ID          = "id";
    private static final int NUM_COL_ID         = 0;
    private static final String COL_NOM         = "nom";
    private static final int NUM_COL_NOM        = 1;
    private static final String COL_PRENOM      = "prenom";
    private static final int NUM_COL_PRENOM     = 2;
    private static final String COL_SURNOM      = "surnom";
    private static final int NUM_COL_SURNOM     = 3;
    private static final String COL_NUMERO      = "numero";
    private static final int NUM_COL_NUMERO     = 4;

    private ContentValues contentValues;

    private SQLiteDatabase bdd;

    protected ContactSqlite contactSqlite;

    public ContactCread(Context context) {
        contactSqlite   = new ContactSqlite(context, BDDNAME, null, VERSION_BDD);
    }

    public void open() {
        bdd = contactSqlite.getWritableDatabase();
    }

    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getBdd() {
        return bdd;
    }

    public long insererContact(Contact contact){
        contentValues = new ContentValues();

        contentValues.put(COL_NOM, contact.getNom());
        contentValues.put(COL_PRENOM, contact.getPrenom());
        contentValues.put(COL_SURNOM, contact.getSurnom());
        contentValues.put(COL_NUMERO, contact.getNumero());

        long insert = bdd.insert(TABLE_CONTACT, null, contentValues);
        System.out.println("c'est super");
        return insert;
    }

    public int modifierContact(int id, Contact contact) {
        contentValues = new ContentValues();

        contentValues.put(COL_NOM, contact.getNom());
        contentValues.put(COL_NUMERO, contact.getPrenom());
        contentValues.put(COL_SURNOM, contact.getSurnom());
        contentValues.put(COL_NUMERO, contact.getNumero());

        return bdd.update(TABLE_CONTACT, contentValues, COL_ID + " = " + id, null);
    }

    public Contact listerContactParNom(String nom){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor curseur = bdd.query(
                TABLE_CONTACT,
                new String[] { COL_ID, COL_NOM, COL_PRENOM, COL_SURNOM, COL_NUMERO },
                COL_NOM + " = \"" + nom +"\"", null, null, null, null
        );

        return curseurEnContact1(curseur);
    }

    public Contact listerContactParNumero(int numero){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor curseur = bdd.query(
                TABLE_CONTACT,
                new String[] { COL_ID, COL_NOM, COL_PRENOM, COL_SURNOM, COL_NUMERO },
                COL_NUMERO + " = \"" + numero +"\"", null, null, null, null
        );

        return curseurEnContact1(curseur);
    }

    public List<Contact>  listerTousContact() {
        List<Contact> Contacts = new ArrayList<Contact>() {};

        Cursor curseur = bdd.query(
                TABLE_CONTACT,
                new String[] { COL_ID, COL_NOM, COL_PRENOM, COL_SURNOM, COL_NUMERO },
                null, null, null, null, null);

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            Contact Contact = curseurEnContact2(curseur);
            Contacts.add(Contact);
            curseur.moveToNext();
        }
        //fermeture du curseur
        curseur.close();
        return Contacts;
    }

    //Cette méthode permet de convertir un curseur en un contact
    public Contact curseurEnContact1(Cursor curseur){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (curseur.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        curseur.moveToFirst();
        //On créé un contact
        Contact contact = new Contact();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Curseur
        contact.setId(curseur.getInt(NUM_COL_ID));
        contact.setNom(curseur.getString(NUM_COL_NOM));
        contact.setPrenom(curseur.getString(NUM_COL_PRENOM));
        contact.setSurnom(curseur.getString(NUM_COL_SURNOM));
        contact.setNumero(curseur.getInt(NUM_COL_NUMERO));
        //On ferme le cursor
        curseur.close();

        //On retourne le contact
        return contact;
    }

    //Cette méthode permet de convertir un curseur en un contact pour la methode listerTousContact()
    public Contact curseurEnContact2(Cursor curseur){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (curseur.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        curseur.moveToFirst();
        //On créé un contact
        Contact contact = new Contact();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Curseur
        contact.setId(curseur.getInt(NUM_COL_ID));
        contact.setNom(curseur.getString(NUM_COL_NOM));
        contact.setPrenom(curseur.getString(NUM_COL_PRENOM));
        contact.setSurnom(curseur.getString(NUM_COL_SURNOM));
        contact.setNumero(curseur.getInt(NUM_COL_NUMERO));

        //On retourne le contact
        return contact;
    }

    public int supprimerContactAvecId(int id) {
        return bdd.delete(TABLE_CONTACT, COL_ID + " = " + id, null);
    }


}
