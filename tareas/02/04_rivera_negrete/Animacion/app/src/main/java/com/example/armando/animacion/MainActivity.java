package com.example.armando.animacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    Button boton, boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=(Button)findViewById(R.id.Boton);
        boton2=(Button)findViewById(R.id.Boton2);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rota(v);
            }

        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grande(v);
            }
        });

    }

    public void rota (View view) {
        ImageView animationTarget = (ImageView)this.findViewById(R.id.Reliquias);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotar);
        animationTarget.startAnimation(animation);
    }
    public void grande (View view) {
        ImageView animationTarget = (ImageView)this.findViewById(R.id.Reliquias);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.grande);
        animationTarget.startAnimation(animation);
    }

}
