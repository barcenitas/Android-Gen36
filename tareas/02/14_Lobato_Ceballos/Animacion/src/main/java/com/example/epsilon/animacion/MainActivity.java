package com.example.epsilon.animacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button boton;
    ImageView imagen;
    Animation rotacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = (ImageView) findViewById(R.id.img);
        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                rotacion = AnimationUtils.loadAnimation(getApplicationContext(), R.animator.rotar);
                imagen.startAnimation(rotacion);
            }
        });
    }


}
