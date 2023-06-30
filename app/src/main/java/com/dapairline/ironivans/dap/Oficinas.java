package com.dapairline.ironivans.dap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Oficinas extends AppCompatActivity {

    public String fono;
    public String mapa;
    public String mapa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oficinas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView llamarPuq = (ImageView) findViewById(R.id.callPuq);
        ImageView llamarWpu = (ImageView) findViewById(R.id.callWpu);
        ImageView llamarWpr = (ImageView) findViewById(R.id.callWpr);
        ImageView llamarBba = (ImageView) findViewById(R.id.callBba);

        llamarPuq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Oficinas.this, R.anim.animacion));
                fono = getResources().getString(R.string.telefonoPUQ);
                llamar(fono);
            }
        });
        llamarWpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Oficinas.this, R.anim.animacion));
                fono = getResources().getString(R.string.telefonoWPU);
                llamar(fono);
            }
        });
        llamarWpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Oficinas.this, R.anim.animacion));
                fono = getResources().getString(R.string.telefonoWPR);
                llamar(fono);
            }
        });
        llamarBba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Oficinas.this, R.anim.animacion));
                fono = getResources().getString(R.string.telefonoBBA);
                llamar(fono);
            }
        });

        ImageView mapaPuq = (ImageView) findViewById(R.id.mapPuq);
        mapaPuq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Oficinas.this, R.anim.animacion));
                mapa = "-53.160717,-70.9007248";
                mapa2 = "(Ignacio Carrera Pinto 1015)";
                verMapa(mapa,mapa2);
            }
        });
        ImageView mapaBba = (ImageView) findViewById(R.id.mapBba);
        mapaBba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Oficinas.this, R.anim.animacion));
                mapa = "-45.5718612,-72.072786";
                mapa2 = "(Arturo Prat 286)";
                verMapa(mapa,mapa2);
            }
        });
        ImageView mapaWpu = (ImageView) findViewById(R.id.mapWpu);
        mapaWpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Oficinas.this, R.anim.animacion));
                mapa = "-54.935143, -67.606666";
                mapa2 = "(Plaza del Ancla S/N.)";
                verMapa(mapa,mapa2);
            }
        });
        ImageView mapaWpr = (ImageView) findViewById(R.id.mapWpr);
        mapaWpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(Oficinas.this, R.anim.animacion));
                mapa = "-53.298775, -70.371433";
                mapa2 = "(Manuel Señoret S/N. )";
                verMapa(mapa,mapa2);
            }
        });



    }

    public void llamar(String telefono){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+telefono));
        startActivity(i);
    }

    public void verMapa(String mapa, String mapa2){
       /*Uri gmmIntentUri = Uri.parse("geo:"+mapa);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }*/
        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+mapa+mapa2);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

}
