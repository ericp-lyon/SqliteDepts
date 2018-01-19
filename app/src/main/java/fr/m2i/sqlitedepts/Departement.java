package fr.m2i.sqlitedepts;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Administrateur on 19/01/2018.
 */

public class Departement {

    private SQLiteDatabase db;
    String noDept, nom, nomStd, dateCréation, chefLieu, urlWiki;
    int noRegion, surface;
    final String COLONNE[] = {"no_dept", "no_region", "nom", "nom_std", "surface", "date_creation", "chef_lieu", "url_wiki"};


    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

    public String getNoDept() {
        return noDept;
    }

    public void setNoDept(String noDept) {
        this.noDept = noDept;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomStd() {
        return nomStd;
    }

    public void setNomStd(String nomStd) {
        this.nomStd = nomStd;
    }

    public String getDateCréation() {
        return dateCréation;
    }

    public void setDateCréation(String dateCréation) {
        this.dateCréation = dateCréation;
    }

    public String getChefLieu() {
        return chefLieu;
    }

    public void setChefLieu(String chefLieu) {
        this.chefLieu = chefLieu;
    }

    public String getUrlWiki() {
        return urlWiki;
    }

    public void setUrlWiki(String urlWiki) {
        this.urlWiki = urlWiki;
    }

    public int getNoRegion() {
        return noRegion;
    }

    public void setNoRegion(int noRegion) {
        this.noRegion = noRegion;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public Departement(Context c) {

        DbInit dbInit = new DbInit(c);
        db = dbInit.getWritableDatabase();

    }

    public Departement(String noDept) {
        this.noDept = noDept;
    }


    public void select(String noDept) throws Exception {

        String where = "no_dept = '" + noDept + "'";


        Cursor cursor = db.query("departements", COLONNE, where, null, null, null, null);


        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            this.noDept = cursor.getString(0);
            this.noRegion = cursor.getInt(1);
            this.nom = cursor.getString(2);
            this.nomStd = cursor.getString(3);
            this.surface = cursor.getInt(4);
            this.dateCréation = cursor.getString(5);
            this.chefLieu = cursor.getString(6);
            this.urlWiki = cursor.getString(7);


        } else if (cursor.getCount() > 1) {
            //création d'une exception personnalisé suite plusieurs contacts  trouvé lors du query
            throw new Exception();
        } else {
            //création d'une exception personnalisé suite contact non trouvé lors du query
            throw new Exception();
        }
    }



}












