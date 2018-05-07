package com.example.dell.a17_guardar_estado;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout lay;
    Button boton;
    Button botonguardar;
    int num_color;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String COLOR = "0";

    private int color_nuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        lay = findViewById ( R.id.fondo );
        boton = findViewById ( R.id.button );
        botonguardar = findViewById ( R.id.savebutton );

        boton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt (256));
                num_color=color;
                lay.setBackgroundColor ( color );
            }
        } );

        botonguardar.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                    saveData();
            }
        } );

        loadData ();
        updateViews ();
    }

    public void saveData(){

        SharedPreferences sh = getSharedPreferences ( SHARED_PREFS, MODE_PRIVATE );
        SharedPreferences.Editor editor = sh.edit ();

        editor.putInt (COLOR, num_color);
        editor.apply ();
        Toast.makeText (this, "cambios guardados", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sh = getSharedPreferences ( SHARED_PREFS, MODE_PRIVATE );
        color_nuevo = sh.getInt (COLOR,5);
    }

    public void updateViews(){
        lay.setBackgroundColor (color_nuevo);
    }
}
