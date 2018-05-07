package com.example.hector.actividad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class Actividad2 extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);
        View btn = findViewById(R.id.button1);
        btn.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.Menu.actividad2,menu);
    }

    public void onClick(View v){
        Intent regresar = new Intent(this,MainActivity.class);
        startActivity(regresar);
        Toast.makeText(this,"Pasando a la actividad 1",Toast.LENGTH_LONG).show();
        }




}
