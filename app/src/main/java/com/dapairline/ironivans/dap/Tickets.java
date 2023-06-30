package com.dapairline.ironivans.dap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tickets extends AppCompatActivity {

    private List<String> item = null;
    String path;
    int bandera=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listFilesProp();
    }

    private void listFilesProp(){
        final List<String> list = new ArrayList<String>();
        //obtiene ruta donde se encuentran los archivos.
        path = getExternalFilesDir("Tickets")+ File.separator;


        File f = new File(path);
        //obtiene nombres de archivos dentro del directorio.
        File file[] = f.listFiles();
        for (int i=0; i < file.length; i++)
        {
            Log.d("Files", "Archivo : " + file[i].getName());
            //Agrega nombres de archivos a List para ser agregado a adapter.
            list.add(file[i].getName());
            bandera=i;

        }

        ListView listview = (ListView)findViewById(R.id.listaFilesTkt);
        //Crea Adapter
        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list );*/

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.single_row_ticket,
                R.id.tituloPdfTkt,
                list );
        //Configura Adapter a ListView.
        listview.setAdapter(arrayAdapter);

        TextView vacio = (TextView) findViewById(R.id.vacioTkt);
        if(bandera!=0){
            listview.setVisibility(View.VISIBLE);
            vacio.setVisibility(View.GONE);
        }else{
            listview.setVisibility(View.GONE);
            vacio.setVisibility(View.VISIBLE);
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viewPdf(list.get(i));
            }
        });
    }

    private void viewPdf(String file) {

        File pdfFile = new File(getExternalFilesDir("Tickets")+ File.separator+ file);
        //TextView ruta = (TextView) findViewById(R.id.ruta);
        //ruta.setText((CharSequence) pdfFile.toString());
        //Uri path = Uri.fromFile(pdfFile);

        Uri path = FileProvider.getUriForFile(Tickets.this,
                BuildConfig.APPLICATION_ID + ".provider",
                pdfFile);

        // Setting the intent for pdf reader
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);


        startActivity(pdfIntent);

    }


}
