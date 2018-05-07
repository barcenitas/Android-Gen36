package com.example.usuario.appuno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Animar(View view)
    {
        ImageView imagen = (ImageView) findViewById(R.id.Gaara);
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.hyperspacejump);
        imagen.startAnimation(animacion);
    }
}
