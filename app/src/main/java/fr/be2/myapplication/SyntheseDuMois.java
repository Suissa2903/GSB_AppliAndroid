package fr.be2.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class SyntheseDuMois extends AppCompatActivity {
    private SQL_Helper BDD;
    private SimpleCursorAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthese_du_mois);
        BDD= new SQL_Helper(this);
        BDD.open();
        displayListView();
    }
    public void clique_Retour(View view){
        finish();
    }


    private void displayListView() {


        Cursor cursor = BDD.fetchAllFrais();
        // Les colonnes que l’on veut lier
        String[] columns = new String[] {
               BDD.Type,
               BDD.Libele,
                BDD.Quantite,
               BDD.Montant,
               BDD.Date,
                BDD.ID,


        };

        // Les éléments defnis dans le XML auxquels les données sont liées
        int[] to = new int[] {
                R.id.Type,
                R.id.Libelle,
                R.id.Quantite,
                R.id.montant,
                R.id.date,
                R.id.id,
        };
        //On créer l'adaptateur à l'aide du curseur pointant sur les données souhaitées  ainsi que les informations de mise en page
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.frais_info,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.listView1);
        // Attribuer l’adapter au ListView
        listView.setAdapter(dataAdapter);


       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // On obtient le curseur, positionne sur la ligne correspondante dans le jeu de résultats
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // On obtient la Capital du pays
                String myid=
                        cursor.getString(0);
                Toast.makeText(getApplicationContext(),
                       myid, Toast.LENGTH_SHORT).show();
                BDD.deleteData(Integer.parseInt(myid));


            }


        });

/*
        EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

           public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

        dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            public Cursor runQuery(CharSequence constraint) {
                return BDD.fetchFraisByName(constraint.toString());
            }
        });*/
       /* public void clique_retour(View view) {
            finish();
        }
*/

    }
    }











