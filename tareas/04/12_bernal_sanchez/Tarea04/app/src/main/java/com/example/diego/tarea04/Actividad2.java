package com.example.diego.tarea04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Actividad2 extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        View btn2 = findViewById(R.id.boton2);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent avanza = new Intent(this, MainActivity.class);
        startActivity(avanza);
        Toast.makeText(this, "Cambiando a la actividad 3", Toast.LENGTH_SHORT).show();

    }
}
