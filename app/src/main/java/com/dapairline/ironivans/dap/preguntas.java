package com.dapairline.ironivans.dap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class preguntas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageButton btnTarifas = (ImageButton) findViewById(R.id.tarifas);
        btnTarifas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(preguntas.this, R.anim.animacion));
                Intent intent = new Intent(preguntas.this, tarifas.class);
                startActivity(intent);
            }
        });

        ImageButton btnEquipaje = (ImageButton) findViewById(R.id.equipaje);
        btnEquipaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(preguntas.this, R.anim.animacion));
                Intent intent = new Intent(preguntas.this, equipaje.class);
                startActivity(intent);
            }
        });

        ImageButton btnInformacion = (ImageButton) findViewById(R.id.informacion);
        btnInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(preguntas.this, R.anim.animacion));
                Intent intent = new Intent(preguntas.this, informacion.class);
                startActivity(intent);
            }
        });

        ImageButton btnCondiciones = (ImageButton) findViewById(R.id.condiciones);
        btnCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                v.startAnimation(AnimationUtils.loadAnimation(preguntas.this, R.anim.animacion));
                Intent intent = new Intent(preguntas.this, condiciones.class);
                startActivity(intent);
            }
        });


    }

}
