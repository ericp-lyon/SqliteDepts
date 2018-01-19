package fr.m2i.sqlitedepts;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText txtSearch,txtNoDept,txtNoRegion,txtNom,txtNomStd,txtSurface,txtDateCreation,txtChefLieu,txtUrlWiki;


     SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSearch = findViewById(R.id.txtSearch);
        txtNoDept = findViewById(R.id.txtNoDept);
        txtNoRegion = findViewById(R.id.txtNoRegion);
        txtNom = findViewById(R.id.txtNom);
        txtNomStd = findViewById(R.id.txtNomStd);
        txtSurface = findViewById(R.id.txtSurface);
        txtDateCreation = findViewById(R.id.txtDateCreation);
        txtChefLieu = findViewById(R.id.txtChefLieu);
        txtUrlWiki = findViewById(R.id.txtUrlWiki);

        DbInit dbInit = new DbInit(this);
        db = dbInit.getWritableDatabase();





    }


    public void btnSearch(View v){

        Departement d = new Departement(this);
        try {
            //Toast.makeText(this, "ok",Toast.LENGTH_LONG).show();

            d.select(txtSearch.getText().toString());

            txtNoDept.setText(d.getNoDept().toString());
            txtNoRegion.setText(String.valueOf(d.getNoRegion()));
            txtNom.setText(d.getNom().toString());
            txtNomStd.setText(d.getNomStd().toString());
           txtSurface.setText(String.valueOf(d.getSurface()));
            txtDateCreation.setText(d.getDateCréation().toString());
            txtChefLieu.setText(d.getChefLieu().toString());
           txtUrlWiki.setText(d.getUrlWiki().toString());

            Toast.makeText(this, "information trouvé",Toast.LENGTH_LONG).show();

        } catch (Exception e) {
           Toast.makeText(this,"modifiez la saisie",Toast.LENGTH_LONG).show();
        }
    }
    public void btnClear(View v){

        txtSearch.setText("");
        txtNoDept.setText("");
        txtNoRegion.setText("");
        txtNom.setText("");
        txtNomStd.setText("");
        txtSurface.setText("");
        txtDateCreation.setText("");
        txtChefLieu.setText("");
        txtUrlWiki.setText("");

    }
    public void btnDelete(View v){

    




    }
    public void btnSave(View v){


    }
}
