package com.example.usuario.tareajueves;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity implements View.OnClickListener {
    Button cambiarAct;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Iniciar();
    }

    public void Iniciar()
    {
        cambiarAct = (Button) findViewById(R.id.CambiarActividad);
        cambiarAct.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.CambiarActividad:
                i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
