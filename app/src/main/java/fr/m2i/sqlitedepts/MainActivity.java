package fr.m2i.sqlitedepts;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtSearch, txtNoDept, txtNoRegion, txtNom, txtNomStd, txtSurface, txtDateCreation, txtChefLieu, txtUrlWiki;
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


    public void btnSearch(View v) {

        Departement departement = new Departement(this);
        try {

            departement.select(txtSearch.getText().toString());

            txtNoDept.setText(departement.getNoDept().toString());
            txtNoRegion.setText(String.valueOf(departement.getNoRegion()));
            txtNom.setText(departement.getNom().toString());
            txtNomStd.setText(departement.getNomStd().toString());
            txtSurface.setText(String.valueOf(departement.getSurface()));
            txtDateCreation.setText(departement.getDateCréation().toString());
            txtChefLieu.setText(departement.getChefLieu().toString());
            txtUrlWiki.setText(departement.getUrlWiki().toString());

            Toast.makeText(this, "information trouvé", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(this, "modifiez la saisie", Toast.LENGTH_LONG).show();
        }
    }

    public void btnClear(View v) {

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

    public void btnDelete(View v) {

        Departement departement = new Departement(this);

        String noDepartEffacer = (txtNoDept.getText().toString());
        departement.setNoDept(noDepartEffacer);

        if (noDepartEffacer.equals("")) {
            Toast.makeText(this, "département introuvable", Toast.LENGTH_LONG).show();
        }
        try {
            departement.delete(noDepartEffacer);
            Toast.makeText(this, "département " + noDepartEffacer + " est effacé", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(this, "modifiez la saisie", Toast.LENGTH_LONG).show();
        }


    }

    public void btnSave(View v) {

        try {
            Departement departement = new Departement(this);

            departement.setNoDept(txtNoDept.getText().toString());
            departement.setNoRegion(Integer.parseInt(txtNoRegion.getText().toString()));
            departement.setNom(txtNom.getText().toString());
            departement.setNomStd(txtNomStd.getText().toString());
            departement.setSurface(Integer.parseInt(txtSurface.getText().toString()));
            departement.setDateCréation(txtDateCreation.getText().toString());
            departement.setChefLieu(txtChefLieu.getText().toString());
            departement.setUrlWiki(txtUrlWiki.getText().toString());


            if(txtNoRegion.getText().toString().equals("")){

                departement.insert();
                Toast.makeText(this,"contact ajouté",Toast.LENGTH_LONG).show();
            }else {
                departement.setNoRegion(Integer.parseInt(txtNoRegion.getText().toString()));
                departement.update();
                Toast.makeText(this, "contact maj", Toast.LENGTH_LONG).show();
                

            }
        } catch (Exception e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }


    }
}
