package com.example.dell.a17_animacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    Button boton;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        img = findViewById ( R.id.imagen );
        boton = findViewById ( R.id.button_animate );
        boton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                YoYo.with( Techniques.RubberBand).duration(100).repeat(10).playOn(img);

            }
        } );
    }
}
