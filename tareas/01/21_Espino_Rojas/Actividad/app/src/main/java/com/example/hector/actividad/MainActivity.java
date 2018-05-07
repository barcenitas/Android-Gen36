    package com.example.hector.actividad;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity implements  OnClickListener{

        Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View btn = findViewById(R.id.button1);
        navegador();
       btn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main,menu);
        return true;
    }

    @Override
    public void onClick(View v){
        Intent abrir = new Intent(this,Actividad2.class);
        startActivity(abrir);
        Toast.makeText(this,"Pasando a la actividad 2",Toast.LENGTH_LONG).show();
    }

        public void navegador(){

            btn = (Button) findViewById(R.id.internet);

            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("https://www.google.com.mx/");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Abriendo video de gmi2", Toast.LENGTH_SHORT).show();

                }
            });
        }




}
