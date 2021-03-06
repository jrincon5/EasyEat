package co.edu.eafit.easyeat.Controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import java.io.IOException;
import java.util.ArrayList;
import app.jdavid.com.Controladores.R;

public class subMenuActivity extends AppCompatActivity {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    ListViewAdapter adapterCarrito;
    SparseArray<GrupoItems> grupos = new SparseArray<GrupoItems>();
    private SparseArray<String> titulos=new SparseArray<String>();
    private SparseArray<Integer>imagenes=new SparseArray<Integer>();
    private static String restaurante;
    private static String categoria;

    public static String getCategoria() {return categoria;}
    public static void setCategoria(String categoria) {subMenuActivity.categoria = categoria;}
    public String getRestaurante() {return restaurante;}
    public void setRestaurante(String restaurante) {this.restaurante = restaurante;}
    public ArrayList<String> pedidos = new ArrayList();

    public void crearDatos(String restaurante){
        if(restaurante.equals("Bigos")){
            if(categoria.equals("Combos")){
                GrupoItems grupo0 = new GrupoItems("Combo 1");
                grupo0.subItem.add("$12000 \n 2 presas de pollo con frijoles");
                grupo0.subFoto.add(R.drawable.bigoscomida);
                grupos.append(0, grupo0);
                GrupoItems grupo1 = new GrupoItems("Combo 1 Ensalada de Papa");
                grupo1.subItem.add("$18800 \n ensalada de papas con almuerzo");
                grupo1.subFoto.add(R.drawable.bigos);
                grupos.append(1, grupo1);
                GrupoItems grupo2 = new GrupoItems("Combo 2 Ensalada de Repollo");
                //grupo2.subItem.add("Frispicada  $39900");
                //grupo1.subFoto.add(R.drawable.frisby);
                grupo2.subItem.add("$14900 \n ensalada deliciosa con pechuga de pollo");
                grupo2.subFoto.add(R.drawable.bigos);
                //grupo2.subItem.add("Frisburrito Ranch   $6500");
                //grupo2.subFoto.add(R.drawable.bigos);
                grupos.append(2, grupo2);
            }else if(categoria.equals("Emparedados")){
                GrupoItems grupo0 = new GrupoItems("Combo 1");
                grupo0.subItem.add("$12000 \n 2 presas de pollo con frijoles");
                grupo0.subFoto.add(R.drawable.bigoscomida);
                grupos.append(0, grupo0);
                GrupoItems grupo1 = new GrupoItems("Combo 1 Ensalada de Papa");
                grupo1.subItem.add("$18800 \n ensalada de papas con almuerzo");
                grupo1.subFoto.add(R.drawable.bigos);
                grupos.append(1, grupo1);
                GrupoItems grupo2 = new GrupoItems("Combo 2 Ensalada de Repollo");
                //grupo2.subItem.add("Frispicada  $39900");
                //grupo1.subFoto.add(R.drawable.frisby);
                grupo2.subItem.add("$14900 \n ensalada deliciosa con pechuga de pollo");
                grupo2.subFoto.add(R.drawable.bigos);
                //grupo2.subItem.add("Frisburrito Ranch   $6500");
                //grupo2.subFoto.add(R.drawable.bigos);
                grupos.append(2, grupo2);
            }
        }
        if(restaurante.equals("Frisby")) {
            if(categoria.equals("Combos")){
                GrupoItems grupo0 = new GrupoItems("Combo 1 Ensalada de Repollo");
                grupo0.subItem.add("$12000 \n 2 presas de pollo apanadado crocantes, acompañadas de arroz, ensalada de repollo y salsa");
                grupo0.subFoto.add(R.drawable.comboensaladarepollo);
                grupos.append(0, grupo0);
                GrupoItems grupo1 = new GrupoItems("Combo 1 Ensalada de Papa");
                grupo1.subItem.add("$18800 \n muslo de pollo apanado con papas");
                grupo1.subFoto.add(R.drawable.frisby);
                grupos.append(1, grupo1);
                GrupoItems grupo2 = new GrupoItems("Combo 2 Ensalada de Repollo");
                //grupo2.subItem.add("Frispicada  $39900");
                //grupo1.subFoto.add(R.drawable.frisby);
                grupo2.subItem.add("$14900 ensalada deliciosa con pechuga de pollo");
                grupo2.subFoto.add(R.drawable.frisby);
                //grupo2.subItem.add("Frisburrito Ranch   $6500");
                grupo2.subFoto.add(R.drawable.frisby);
                grupos.append(2, grupo2);
            }
            if(categoria.equals("Pollo")){
                GrupoItems grupo0 = new GrupoItems("Combo Muslos");
                grupo0.subItem.add("$12000 \n 4 muslos de pollo apanadado crocantes");
                grupo0.subFoto.add(R.drawable.comboensaladarepollo);
                grupos.append(0, grupo0);
                GrupoItems grupo1 = new GrupoItems("Combo Pechuga");
                grupo1.subItem.add("$18800 \n pechugas apanadas de pollo con papas");
                grupo1.subFoto.add(R.drawable.frisby);
                grupos.append(1, grupo1);
                GrupoItems grupo2 = new GrupoItems("Combo 2 Ensalada de Repollo");
                //grupo2.subItem.add("Frispicada  $39900");
                //grupo1.subFoto.add(R.drawable.frisby);
                grupo2.subItem.add("$14900 ensalada deliciosa con pechuga de pollo");
                grupo2.subFoto.add(R.drawable.frisby);
                //grupo2.subItem.add("Frisburrito Ranch   $6500");
                grupo2.subFoto.add(R.drawable.frisby);
                grupos.append(2, grupo2);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);
        crearDatos(restaurante);
        LlenarRestaurantes(restaurante);
        // Tab
        TabHost tbh = (TabHost) findViewById(R.id.tabHost);
        tbh.setup();
        // TAB Pestaña 1
        TabSpec tb1 = tbh.newTabSpec("Tab1");
        tb1.setIndicator("Productos");
        tb1.setContent(R.id.tab1);
        tbh.addTab(tb1);

        ImageView imgImg = (ImageView) findViewById(R.id.subMenuImagenLogo);  // cambio
        imgImg.setImageResource(R.drawable.frisby);  // cambio
        TextView txtTitulo = (TextView) findViewById(R.id.TituloTxT);
        txtTitulo.setText("    " + categoria);
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.ListViewsubMenu);
        ExpandableListViewAdapter adapter = new ExpandableListViewAdapter(this, grupos);
        listView.setAdapter(adapter);

        // TAB Pestaña 2
        TabSpec tb2 = tbh.newTabSpec("Tab2");
        tb2.setIndicator("Carrito");
        tb2.setContent(R.id.tab2);
        tbh.addTab(tb2);

        final ListView lista = (ListView) findViewById(R.id.Lista_Carrito);
        adapterCarrito = new ListViewAdapter(this, titulos, imagenes);
        lista.setAdapter(adapterCarrito);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), getTituloMenu(i), Toast.LENGTH_SHORT).show();
            }
        });
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Se realizo el pedido", Toast.LENGTH_SHORT).show();
                String aux = "";
                for (String text : pedidos) {
                    aux += pedidos + "\n";
                }
                Toast.makeText(getApplicationContext(), aux, Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                String text = gson.toJson(pedidos);
                if (text == null) {
                    Log.i("SE CAGO", "EL toJson");
                }
                OkHttpClient client = new OkHttpClient();
                try {
                    post("http://easyeatserver.herokuapp.com/echo", text, new Callback() {
                        @Override
                        public void onFailure(Request request, IOException throwable) {
                            // Something went wrong
                        }
                        @Override
                        public void onResponse(Response response) throws IOException {
                            if (response.isSuccessful()) {
                                String responseStr = response.body().string();
                                //Toast.makeText(getApplicationContext(),responseStr, Toast.LENGTH_SHORT).show();
                                // Do what you want to do with the response.
                            }else{
                                // Request not successful
                            }
                        }
                    },client);
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Se cago esto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /* Evento para cambiar las pestañas
        tbh.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("AndroidTabsDemo", "Pulsada pestaña: " + tabId);
            }
        });*/
    }

    void LlenarRestaurantes(String rest){
        if(rest.equals("Frisby")){
            titulos.append(0, "Combos");
            imagenes.append(0, R.drawable.frisby);
            titulos.append(1, "Pollo");
            imagenes.append(1, R.drawable.frisby);
            titulos.append(2, "Frisdelicias");
            imagenes.append(2, R.drawable.frisby);
            titulos.append(3, "Linea Liviana");
            imagenes.append(3, R.drawable.frisby);
            titulos.append(4, "Frisby Kids");
            imagenes.append(4, R.drawable.frisby);
            titulos.append(5, "Acompañamientos");
            imagenes.append(5, R.drawable.frisby);
            titulos.append(6, "Bebidas");
            imagenes.append(6, R.drawable.frisby);
            titulos.append(7, "Postres");
            imagenes.append(7, R.drawable.frisby);
        }else
        if(rest.equals("Bigos")) {
            titulos.append(0, "Combos");
            imagenes.append(0, R.drawable.bigos);
            titulos.append(1, "Emparedados");
            imagenes.append(1, R.drawable.bigos);
            titulos.append(2, "Especiales");
            imagenes.append(2, R.drawable.bigos);
            titulos.append(3, "Linea Liviana");
            imagenes.append(3, R.drawable.bigos);
            titulos.append(4, "Menu del día");
            imagenes.append(4, R.drawable.bigos);
            titulos.append(5, "Adiciones");
            imagenes.append(5, R.drawable.bigos);
            titulos.append(6, "Bebidas");
            imagenes.append(6, R.drawable.bigos);
            titulos.append(7, "Postres");
            imagenes.append(7, R.drawable.bigos);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub_menu, menu);
        return true;
    }
    Call post(String url, String json, Callback callback, OkHttpClient client) throws IOException {
        if(json==null){
            Log.i("SE CAGO","EL json");
        }
        //RequestBody text = RequestBody.create(JSON, json);
        RequestBody text = new FormEncodingBuilder().add("text",json).build();
        if(text==null){
            Log.i("SE CAGO","EL body");
        }
        Request request = new Request.Builder()
                .url(url)
                .post(text)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_escanear:
                Intent scan = new Intent(subMenuActivity.this,escanearActivity.class);
                startActivity(scan);
                return true;
            case R.id.action_aliados:
                scan = new Intent(subMenuActivity.this,aliadosActivity.class);
                startActivity(scan);
                return true;
            case R.id.action_menu:
                scan = new Intent(subMenuActivity.this,menuActivity.class);
                startActivity(scan);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}