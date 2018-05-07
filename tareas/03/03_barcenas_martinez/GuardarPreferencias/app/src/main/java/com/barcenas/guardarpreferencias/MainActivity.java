package com.barcenas.guardarpreferencias;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.RelativeLayout;

import static junit.runner.BaseTestRunner.savePreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences colores;
    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colores = getSharedPreferences("Data", Context.MODE_PRIVATE);
        iniciar();
        recuperarDatos();
    }


    public void iniciar(){
        Button botonAzul = (Button)findViewById(R.id.azul);
        Button botonMorado = (Button)findViewById(R.id.morado);
        botonAzul.setOnClickListener(this);
        botonMorado.setOnClickListener(this);
    }


    private void recuperarDatos(){
        color = colores.getString("color","");
        RelativeLayout rn = (RelativeLayout)findViewById(R.id.colorado);
        if(color == "")
        {
            rn.setBackgroundColor(Color.YELLOW);
        }
        else
        {
            rn.setBackgroundColor(Color.parseColor(color));
        }
    }

    @Override
    public void onClick(View view){

        switch(view.getId()){

            case R.id.morado:
                cambiarMorado();
                break;
            case R.id.azul:
                cambiarAzul();
                break;
        }
    }


    public void cambiarAzul(){
        SharedPreferences.Editor edit = colores.edit();
        RelativeLayout rn = (RelativeLayout)findViewById(R.id.colorado);
        rn.setBackgroundColor(Color.BLUE);
        edit.putString("color", "BLUE");
        edit.commit();
        edit.apply();
    }

    public void cambiarMorado(){
        SharedPreferences.Editor edit = colores.edit();
        RelativeLayout rn = (RelativeLayout)findViewById(R.id.colorado);
        rn.setBackgroundColor(Color.MAGENTA);
        edit.putString("color", "MAGENTA");
        edit.commit();
        edit.apply();
    }
}
