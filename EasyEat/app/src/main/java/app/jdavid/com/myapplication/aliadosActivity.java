package app.jdavid.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class aliadosActivity extends AppCompatActivity {

    ListViewAdapter adapter;

    private SparseArray<String> titulos=new SparseArray<String>();
    private SparseArray<Integer>imagenes=new SparseArray<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aliados);

        titulos.append(0, "El Rancherito"); imagenes.append(0,R.drawable.rancherito);
        titulos.append(1,"Bigos"); imagenes.append(1,R.drawable.bigos);
        titulos.append(2,"El corral"); imagenes.append(2,R.drawable.elcorral);
        titulos.append(3,"Frisby"); imagenes.append(3,R.drawable.frisby);
        titulos.append(4,"Presto"); imagenes.append(4,R.drawable.presto);
        titulos.append(5,"Crepes & Waffles"); imagenes.append(5,R.drawable.crepe);
        titulos.append(6,"Asados Doña Rosa"); imagenes.append(6,R.drawable.rosa);
        titulos.append(7,"Qbano"); imagenes.append(7,R.drawable.qbano);
        titulos.append(8,"Dogger"); imagenes.append(8,R.drawable.dogger);
        titulos.append(9,"Pizzas Piccolo"); imagenes.append(9,R.drawable.pizzas);
        titulos.append(10,"McDonald's"); imagenes.append(10,R.drawable.mc);
        titulos.append(11,"Burger King"); imagenes.append(11,R.drawable.burger);


        final ListView lista = (ListView) findViewById(R.id.Lista_Aliados);
        adapter = new ListViewAdapter(this, titulos, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), getTituloAliado(i), Toast.LENGTH_SHORT).show();
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "presiono LARGO " + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aliados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_escanear:
                Intent scan = new Intent(aliadosActivity.this,escanearActivity.class);
                startActivity(scan);
                return true;
            case R.id.action_aliados:
                return true;
            case R.id.action_menu:
                scan = new Intent(aliadosActivity.this,menuActivity.class);
                startActivity(scan);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public String getTituloAliado(int i){
        return  titulos.get(i);
    }
}

