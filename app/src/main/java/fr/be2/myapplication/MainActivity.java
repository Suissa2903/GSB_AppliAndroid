package fr.be2.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity {
 // Button FAF, FHF, SYN, PARAM, ENV;
   /* @Override
     public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonFraisForfait:
                Intent intent = new Intent(getApplicationContext(),FraisAuForfait.class);
                startActivity(intent);
                break;
            case R.id.btnMorpion:
                Intent intent1=new Intent(MainActivity.this,Morpion.class);
                MainActivity.this.startActivity(intent1);
              break;
        }
      }
*/
   @Override
      protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);}

      /* public void init()
       {
        FAF = findViewById( R.id.buttonFraisForfait);
        FHF = findViewById( R.id.buttonFraisHorsForfait) ;
        SYN = findViewById( R.id.buttonSynthese) ;
        PARAM = findViewById(R.id.buttonParametres) ;
        ENV = findViewById( R.id.buttonEnvoi) ; }
*/

         // @Override
     public void onClick(View view){
        if (view.getId() == R.id.buttonFraisForfait) {
            Intent intent = new Intent(getApplicationContext(), FraisAuForfait.class);
            startActivity(intent);
        }
        if (view.getId()== R.id.buttonFraisHorsForfait) {
            Intent intent = new Intent(getApplicationContext(), FraisHorsForfait.class);
            startActivity(intent);
        }
        if (view.getId()== R.id.buttonSynthese) {
            Intent intent = new Intent(getApplicationContext(), SyntheseDuMois.class);
            startActivity(intent);
        }
        if (view.getId()== R.id.buttonEnvoi) {
            Intent intent = new Intent(getApplicationContext(), EnvoiDesDonnees.class);
            startActivity(intent);
        }
        if (view.getId()== R.id.buttonParametres) {
            Intent intent = new Intent(getApplicationContext(), Parametres.class);
            startActivity(intent);
        }



     }
     public void afficherMessage(String titre ,String message){
         AlertDialog.Builder Builder = new AlertDialog.Builder(this) ;
         Builder.setCancelable(true) ;
         Builder.setTitle(titre) ;
         Builder.setMessage(message) ;
         Builder.show() ;
     }

   }

