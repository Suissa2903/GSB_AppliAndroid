package fr.be2.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class FraisHorsForfait extends AppCompatActivity {
    SQL_Helper BDD ;
    EditText Libele;
    EditText Montant;
    EditText Date ;
    DatePickerDialog picker;
    Calendar calendrier = Calendar.getInstance();
    int aaaa = calendrier.get(Calendar.YEAR);
    int mm = calendrier.get(Calendar.MONTH);
    int JJ = calendrier.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frais_hors_forfait);
        BDD = new SQL_Helper(this);
        Libele=findViewById(R.id.Libelle);
        Montant=findViewById(R.id.Montant);
        Date=findViewById(R.id.Date);
    }

    public void save_Data(View view){
        String Libele1= Libele.getText().toString()  ;
        Float Montant1= Float.parseFloat(Montant.getText().toString()) ;
        String Date1= Date.getText().toString() ;

        if(BDD.insertData(Libele1,"frais hors forfait",1, Montant1, Date1)){
            Libele.setText(" ");
            Montant.setText(" ");
            Date.setText(" ");
            Toast.makeText(this,"Frais enregistré" ,Toast.LENGTH_LONG).show();


        }
    }

    public void Picker(View vv)
    {
        picker = new DatePickerDialog(FraisHorsForfait.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                       Date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                },aaaa, mm, JJ);
        picker.show();
    }

    public void clique_Retour(View view){
        finish();
    }
}
