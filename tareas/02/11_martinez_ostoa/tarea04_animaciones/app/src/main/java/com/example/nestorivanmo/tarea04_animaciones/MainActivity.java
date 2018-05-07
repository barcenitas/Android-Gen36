package com.example.nestorivanmo.tarea04_animaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgMario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgMario = (ImageView) findViewById(R.id.imgMario);
    }

    protected void animar(View view){
        Animation a1 = AnimationUtils.loadAnimation(this, R.anim.mianimacion);
        a1.setRepeatMode(Animation.RESTART);
        a1.setRepeatMode(5);
        a1.setDuration(2000);
        imgMario.startAnimation(a1);
    }
}
