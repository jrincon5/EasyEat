package app.jdavid.com.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class escanearActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escanear);

        Button bscan = (Button) findViewById(R.id.boton_scan);
        bscan.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_escanear, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_escanear:
                Intent scan = new Intent(escanearActivity.this,escanearActivity.class);
                startActivity(scan);
                return true;
            case R.id.action_aliados:
                scan = new Intent(escanearActivity.this,aliadosActivity.class);
                startActivity(scan);
                return true;
            case R.id.action_menu:
                scan = new Intent(escanearActivity.this,menuActivity.class);
                startActivity(scan);
                return true;
            case R.id.action_pedidos:
                scan = new Intent(escanearActivity.this,pedidosActivity.class);
                startActivity(scan);
                return true;
            case R.id.action_factura:
                scan = new Intent(escanearActivity.this,facturaActivity.class);
                startActivity(scan);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                contents, Toast.LENGTH_SHORT);

                toast1.show();
            }
            if(resultCode == RESULT_CANCELED){
                //handle cancel
            }
        }
    }

    @Override
    public void onClick(View v) {
        System.out.println("Scan");
        try {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes
            startActivityForResult(intent, 0);
        } catch (Exception e) {
            Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
            Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
            startActivity(marketIntent);
        }
    }
}
