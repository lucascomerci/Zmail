package com.example.vicentico.zmail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by vicentico on 9/9/17.
 */



public class Main2 extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuRefrescar:
                Toast.makeText(this,"Refrescar",Toast.LENGTH_SHORT).show();
                //cargarLista();      //reload
                return true;
            case R.id.menuCerrar:
                Toast.makeText(this, "Lista cargada", Toast.LENGTH_LONG).show();
                finish();          //cerrar app
                System.exit(0);
                return true;

            case android.R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_LONG).show();
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setHomeButtonEnabled(true);     // para que aparezca la felchita para volver a la pantalla anterior en la ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        Bundle parametros = getIntent().getExtras();  			// accede a todos los extras utilizados y declarados en el Intent
        String remitente = parametros.getString("remitente");
        String asunto = parametros.getString("asunto");
        String mensaje = parametros.getString("mensaje");

     //   TextView idAsunto = (TextView) view.findViewById(R.id.idAsunto);

        TextView id_asunto_main2 = (TextView) findViewById(R.id.id_asunto_main2);
        id_asunto_main2.setText(asunto);

        TextView id_remitente_main2 = (TextView) findViewById(R.id.id_remitente_main2);
        id_remitente_main2.setText(remitente);

        TextView id_mensaje_main2 = (TextView) findViewById(R.id.id_mensaje_main2);
        id_mensaje_main2.setText(mensaje);




    }

}

