package com.example.usuario.tareajueves;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button cambiarAct, goo;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Iniciar();
    }

    public void Iniciar()
    {
        cambiarAct = (Button) findViewById(R.id.CambiarActividad);
        goo = (Button) findViewById(R.id.Google);
        cambiarAct.setOnClickListener(this);
        goo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.Google:
                Uri webpage = Uri.parse("http://www.google.com");
                i = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(i);
                break;
            case R.id.CambiarActividad:
                i = new Intent(getApplicationContext(), SegundaActivity.class);
                startActivity(i);
                break;
        }
    }
}
