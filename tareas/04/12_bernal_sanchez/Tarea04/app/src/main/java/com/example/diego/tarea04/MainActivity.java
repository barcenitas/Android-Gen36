package com.example.diego.tarea04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btn = findViewById(R.id.boton1);
        btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent inicio = new Intent(this, Actividad2.class);
        startActivity(inicio);
        Toast.makeText(this, "Cambiando a la actividad 2", Toast.LENGTH_SHORT).show();

    }
}
