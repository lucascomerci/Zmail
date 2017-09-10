package com.example.vicentico.zmail;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listaMensajes;
    private SwipeRefreshLayout sflLista;
    private Context context;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuRefrescar:
                Toast.makeText(context,"Refrescar",Toast.LENGTH_SHORT).show();
                cargarLista();      //reload
                return true;
            case R.id.menuCerrar:
                finish();          //cerrar app
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private String colorAleatorio(){    //genero color aleatorio
        int[] androidColors = getResources().getIntArray(R.array.androidcolors);            //traigo el array de colores de colors.xml
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)]; //elijo un color al hazar del array
        String hexColor = String.format("#%06X", (0xFFFFFF & randomAndroidColor));          //Convierto el color de int a String (hexa)
    return hexColor;
    }

    private void cargarLista(){

        final List<Mensaje> mensajes = new ArrayList<>();

        mensajes.add(new Mensaje(1,"Sofia Comerci","juanca@gmail.com","Dia de tortafrita!","Maecenas aliquam, ligula vel mattis sagittis, felis lectus tempus dolor, sit amet bibendum metus erat eu leo. Donec dictum dictum enim. Phasellus semper ipsum non augue hendrerit, id aliquam sem condimentum. Sed ut urna at libero gravida posuere. Proin nec suscipit est, sit amet aliquam enim. Duis tristique mauris placerat varius consequat. Donec vitae erat id lorem porta porta.",colorAleatorio()));
        mensajes.add(new Mensaje(4,"Guillermo Barrios Esquelotto","juanca@gmail.com","Cambio de planes...","Proin tempor quam at ligula volutpat, et dictum lorem commodo. Vestibulum consectetur arcu at neque molestie, ut sollicitudin odio dignissim. Pellentesque semper metus in vulputate commodo. Donec ac tincidunt orci, et pharetra tellus. Vestibulum diam magna, volutpat vitae sapien vel, tristique facilisis erat.",colorAleatorio()));
        mensajes.add(new Mensaje(5,"Macri Gato","juanca@gmail.com","Macri gato","Vestibulum eu mauris fermentum, pellentesque ex vel, vestibulum lorem. Nulla arcu lectus, tincidunt at magna nec, egestas tristique neque. Nullam eget scelerisque enim. Pellentesque nec felis convallis, feugiat nisi id",colorAleatorio()));
        mensajes.add(new Mensaje(6,"Arya Stark","juanca@gmail.com","Yeah hey!","Yeah hey, alright, We'll spend the night together, Wake up and live forever",colorAleatorio()));
        mensajes.add(new Mensaje(7,"Jon Nieve","juanca@gmail.com","am volutpat vulputate interdum","Phasellus porta congue enim, eu scelerisque tortor vehicula a. In vulputate arcu urna, eget scelerisque mauris laoreet sed. Nullam in elementum elit. In dictum odio in sem consectetur volutpat sed non urna. Sed sit amet nisi sagittis, commodo justo id, fringilla tortor. Nam viverra facilisis odio et accumsan.",colorAleatorio()));
        mensajes.add(new Mensaje(8,"Nic.ar","juanca@gmail.com","Novedades","Fusce nibh sapien, congue ut orci eu, bibendum egestas urna. Morbi porta erat tincidunt massa hendrerit egestas. Nunc sit amet quam eu diam volutpat posuere ut sed sem. ",colorAleatorio()));
        mensajes.add(new Mensaje(9,"Los Fabulososos Cadillacs","juanca@gmail.com","Estrechez de Corazon","Duis pharetra ut justo non volutpat. Etiam tempus maximus lectus eu blandit. Donec ut tincidunt mauris. Donec ut porttitor urna, nec malesuada mi. Ut semper dui eget consectetur pellentesque. Donec bibendum turpis in mauris sagittis, vitae feugiat purus ultrices. Duis non est sit amet magna porttitor lacinia et at mi. Aliquam fermentum urna elit, at maximus nisl euismod eget.",colorAleatorio()));
        mensajes.add(new Mensaje(10,"Elon Musk","juanca@gmail.com","FWD: Carmelitas descalzas","Curabitur ullamcorper orci egestas, scelerisque mi at, cursus lectus. Vestibulum ac auctor turpis, eget gravida lectus. Fusce commodo facilisis eros, eget congue metus varius vel.",colorAleatorio()));
        mensajes.add(new Mensaje(11,"Ramon Echegaray","juanca@gmail.com","¿Donde esta Santiago Maldonado?","Aliquam rutrum consequat augue at placerat. Nulla tincidunt sit amet ipsum ut ultricies. Sed rhoncus maximus erat. In ligula nisi, porttitor eget metus sed, varius blandit nunc.",colorAleatorio()));
        mensajes.add(new Mensaje(12,"Ramon Echegaray","juanca@gmail.com","Duis pharetra ut justo non ","Aliquam rutrum consequat augue at placerat. Nulla tincidunt sit amet ipsum ut ultricies. Sed rhoncus maximus erat. In ligula nisi, porttitor eget metus sed, varius blandit nunc.",colorAleatorio()));
        mensajes.add(new Mensaje(13,"Sofia Comerci","juanca@gmail.com","Donec suscipit vel turpis ac vulputate. Donec euismod urna vel sapien vehicula, in porttitor orci cursus","Maecenas aliquam, ligula vel mattis sagittis, felis lectus tempus dolor, sit amet bibendum metus erat eu leo. Donec dictum dictum enim. Phasellus semper ipsum non augue hendrerit, id aliquam sem condimentum. Sed ut urna at libero gravida posuere. Proin nec suscipit est, sit amet aliquam enim. Duis tristique mauris placerat varius consequat. Donec vitae erat id lorem porta porta.",colorAleatorio()));
        mensajes.add(new Mensaje(14,"Guillermo Barrios Esqueltto","juanca@gmail.com","Integer maximus mollis libero","Proin tempor quam at ligula volutpat, et dictum lorem commodo. Vestibulum consectetur arcu at neque molestie, ut sollicitudin odio dignissim. Pellentesque semper metus in vulputate commodo. Donec ac tincidunt orci, et pharetra tellus. Vestibulum diam magna, volutpat vitae sapien vel, tristique facilisis erat.",colorAleatorio()));
        mensajes.add(new Mensaje(15,"Macri Gato","juanca@gmail.com","Ut quam ligula, ullamcorper ut rutrum vitae,","Vestibulum eu mauris fermentum, pellentesque ex vel, vestibulum lorem. Nulla arcu lectus, tincidunt at magna nec, egestas tristique neque. Nullam eget scelerisque enim. Pellentesque nec felis convallis, feugiat nisi id",colorAleatorio()));
        mensajes.add(new Mensaje(16,"Arya Stark","juanca@gmail.com","Suspendisse ac augue pulvinar, rutrum justo","Re copado este mensaje. ",colorAleatorio()));
        mensajes.add(new Mensaje(17,"Jon Nieve","juanca@gmail.com","am volutpat vulputate interdum","Phasellus porta congue enim, eu scelerisque tortor vehicula a. In vulputate arcu urna, eget scelerisque mauris laoreet sed. Nullam in elementum elit. In dictum odio in sem consectetur volutpat sed non urna. Sed sit amet nisi sagittis, commodo justo id, fringilla tortor. Nam viverra facilisis odio et accumsan.",colorAleatorio()));
        mensajes.add(new Mensaje(18,"Nic.ar","juanca@gmail.com","Novedades","Fusce nibh sapien, congue ut orci eu, bibendum egestas urna. Morbi porta erat tincidunt massa hendrerit egestas. Nunc sit amet quam eu diam volutpat posuere ut sed sem. ",colorAleatorio()));

        listaMensajes.setAdapter(new MensajeAdapter(mensajes));
        Toast.makeText(MainActivity.this, "Lista cargada", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayShowHomeEnabled(true);  //Esto es para mostrar el icono a la izquierda del titulo en el action bar
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        listaMensajes = (ListView) findViewById (R.id.lista_mensajes);
        sflLista = (SwipeRefreshLayout) findViewById(R.id.sflLista);

        cargarLista();

        listaMensajes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mensaje item = (Mensaje) listaMensajes.getItemAtPosition(position);
                Intent i;
                i = new Intent(context, Main2.class);
                i.putExtra("remitente",item.getRemitente().toString());
                i.putExtra("asunto",item.getAsunto().toString());
                i.putExtra("mensaje",item.getMensaje().toString());
                startActivity(i);
            }
        });

       sflLista.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                cargarLista();
                sflLista.setRefreshing(false);
            }
        });
    }
}
