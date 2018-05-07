package com.example.diego.animarimagen;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivity extends AppCompatActivity {
    private Context context=this;
    private Button b1;
    private ImageView imagen;
    private Animation rotacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = (ImageView) findViewById(R.id.imagen1);
        b1 = (Button) findViewById(R.id.boton1);

        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rotacion = AnimationUtils.loadAnimation(context, R.anim.rotar);
                imagen.setAnimation(rotacion);
            }
        });

    }




}
