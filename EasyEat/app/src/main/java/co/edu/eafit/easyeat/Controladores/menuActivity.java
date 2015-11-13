package co.edu.eafit.easyeat.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import app.jdavid.com.Controladores.R;
import app.jdavid.com.Controladores.aliadosActivity;
import app.jdavid.com.Controladores.escanearActivity;
import co.edu.eafit.easyeat.Controladores.subMenuActivity;

public class menuActivity extends AppCompatActivity {
    app.jdavid.com.Controladores.ListViewAdapter adapter;
    private SparseArray<String> titulos=new SparseArray<String>();
    private SparseArray<Integer>imagenes=new SparseArray<Integer>();
    private static String restaurante;

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        crearDatos(restaurante);
        //String imagen = restaurante.toLowerCase();
        ImageView imgImg = (ImageView) findViewById(R.id.ImagenMenuTxT);  // cambio
        imgImg.setImageResource(R.drawable.frisby);  // cambio
        TextView txtTitulo = (TextView) findViewById(R.id.TituloMenuTxT);
        txtTitulo.setText("    " + restaurante);

        final ListView lista = (ListView) findViewById(R.id.Lista_Menu);
        adapter = new app.jdavid.com.Controladores.ListViewAdapter(this, titulos, imagenes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), getTituloMenu(i), Toast.LENGTH_SHORT).show();
                subMenuActivity s =new subMenuActivity();
                s.setRestaurante(restaurante);
                s.setCategoria(getTituloMenu(i));
                Intent in = new Intent(menuActivity.this,subMenuActivity.class);
                startActivity(in);
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

    public void crearDatos(String restaurante) {
        if(restaurante.equals("Bigos")){
            titulos.append(0, "Combos");imagenes.append(0, R.drawable.bigos);
            titulos.append(1, "Emparedados");imagenes.append(1, R.drawable.bigos);
            titulos.append(2, "Especiales");imagenes.append(2, R.drawable.bigos);
            titulos.append(3, "Linea Liviana");imagenes.append(3, R.drawable.bigos);
            titulos.append(4, "Menu del día");imagenes.append(4, R.drawable.bigos);
            titulos.append(5, "Adiciones");imagenes.append(5, R.drawable.bigos);
            titulos.append(6, "Bebidas");imagenes.append(6, R.drawable.bigos);
            titulos.append(7, "Postres");imagenes.append(7, R.drawable.bigos);
        }
        if(restaurante.equals("Frisby")){
            titulos.append(0, "Combos"); imagenes.append(0,R.drawable.frisby);
            titulos.append(1,"Pollo"); imagenes.append(1,R.drawable.frisby);
            titulos.append(2,"Frisdelicias"); imagenes.append(2,R.drawable.frisby);
            titulos.append(3,"Linea Liviana"); imagenes.append(3,R.drawable.frisby);
            titulos.append(4,"Frisby Kids"); imagenes.append(4,R.drawable.frisby);
            titulos.append(5,"Acompañamientos"); imagenes.append(5,R.drawable.frisby);
            titulos.append(6,"Bebidas"); imagenes.append(6,R.drawable.frisby);
            titulos.append(7,"Postres"); imagenes.append(7,R.drawable.frisby);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_escanear:
                Intent scan = new Intent(menuActivity.this, escanearActivity.class);
                startActivity(scan);
                return true;
            case R.id.action_aliados:
                scan = new Intent(menuActivity.this, aliadosActivity.class);
                startActivity(scan);
                return true;
            case R.id.action_menu:
                scan = new Intent(menuActivity.this,menuActivity.class);
                startActivity(scan);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public String getTituloMenu(int i){
        return  titulos.get(i);
    }
}