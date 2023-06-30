package com.dapairline.ironivans.dap;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import java.util.Random;

public class Inicio extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Handler imageHandler = new Handler();
    private ConstraintLayout layout;
    private AlertDialog.Builder dialogo1;
    int[] imagenes = new int[]{R.drawable.fonbae, R.drawable.fonant, R.drawable.fontwin};
    String[] monedas;
    private String url;

    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.bienvenido);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imageHandler.post(handle);

        monedas = new String[] {getResources().getString(R.string.clpTexto), getResources().getString(R.string.usdTexto)};
        dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle(R.string.monedaPago);
        dialogo1.setIcon(R.drawable.avion);

        dialogo1.setSingleChoiceItems(monedas, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Intent intentClp = new Intent(Inicio.this, Venta.class);
                        intentClp.putExtra("url", "kibe-v5.kiusys.net");
                        startActivity(intentClp);
                        break;
                    case 1:
                        Intent intentUsd = new Intent(Inicio.this, Venta.class);
                        intentUsd.putExtra("url", "kibe-v5-usd.kiusys.net");
                        startActivity(intentUsd);
                        break;
                }
            }
        });



        dialogo1.setNeutralButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        ImageButton btn = (ImageButton) findViewById(R.id.btnComprar);
        /*DIALOGO MONEDA------>
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                dialogo1.show();
            }
        });
        */
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Inicio.this, R.anim.animacion));
                abrirComprar();
            }
        });

        ImageButton btnCheckin = (ImageButton) findViewById(R.id.btnCheck);
        btnCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Inicio.this, R.anim.animacion));
                abrirCheckin();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_comprar) {
            abrirComprar();
        } else if (id == R.id.nav_checkin) {
            abrirCheckin();
        } else if (id == R.id.nav_oficinas) {
            Intent intent = new Intent(Inicio.this, Oficinas.class);
            startActivity(intent);

        } else if (id == R.id.nav_destinos) {
            Intent intent = new Intent(Inicio.this, destinos.class);
            startActivity(intent);

        } else if (id == R.id.nav_preguntas) {
            Intent intent = new Intent(Inicio.this, preguntas.class);
            startActivity(intent);
        } else if (id == R.id.nav_contacto) {
            Intent intent = new Intent(Inicio.this, Contacto.class);
            startActivity(intent);
        } else if (id == R.id.nav_boarding) {
            Intent intent = new Intent(Inicio.this, Boarding.class);
            startActivity(intent);
        } else if (id == R.id.nav_tickets) {
            Intent intent = new Intent(Inicio.this, Tickets.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private final Runnable handle = new Runnable(){
        public void run(){
            try {
                Random r = new Random();
                int i = r.nextInt(imagenes.length);

                layout = findViewById(R.id.contentFondo);
                layout.setBackground(getResources().getDrawable(imagenes[i]));
            }
            catch (Exception e) {
                Log.d("Test", e.toString());
            }
        }
    };

    /* CUADRO DIALOGO CLP - USD
    public void abrirComprar(){
        dialogo1.show();
    }*/
    public void abrirComprar(){
        Intent intentClp = new Intent(Inicio.this, Venta.class);
        // PRODUCCION--------------> intentClp.putExtra("url", "kibe-v5.kiusys.net/");
        intentClp.putExtra("url", "kibe-stage-v5.kiusys.net/");
        startActivity(intentClp);
    }

    public void abrirCheckin(){
        Intent intent = new Intent(Inicio.this, Checkin.class);
        // PRODUCCION--------------> intent.putExtra("url", "wc2-v5.kiusys.net/");
        intent.putExtra("url", "wc2-stage-v5.kiusys.net/");
        startActivity(intent);
    }
    public void cancelar() {

    }
}
