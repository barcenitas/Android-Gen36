package com.example.diego.preferenciascompartidas;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtnombre;
    private Button btnguardar;
    private CheckBox estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = (EditText) findViewById(R.id.txtnombre);
        btnguardar = (Button) findViewById(R.id.btnguardar);
        estado = (CheckBox) findViewById(R.id.estado);

        cargarPreferencias();

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarPreferencias();
                Toast.makeText(getApplicationContext(), "Has guardado tus preferencias", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cargarPreferencias() {
        SharedPreferences mispreferencias = getSharedPreferences("preferenciasUsuario", Context.MODE_PRIVATE);
        estado.setChecked(mispreferencias.getBoolean("checked", false));
        txtnombre.setText(mispreferencias.getString("nombre", ""));
    }

    public void guardarPreferencias() {
        SharedPreferences mispreferencias = getSharedPreferences("preferenciasUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        boolean valor = estado.isChecked();
        editor.putBoolean("checked", valor);
        String nombre = txtnombre.getText().toString();
        editor.putString("nombre", nombre);
        editor.commit();
    }

}
