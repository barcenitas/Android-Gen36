package com.example.diego.tarea04;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Actividad3 extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        View btn3 = findViewById(R.id.botonExplorador);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent explorador = new Intent(Intent.ACTION_VIEW, Uri.parse("www.proteco.mx"));
        startActivity(explorador);
    }
}
