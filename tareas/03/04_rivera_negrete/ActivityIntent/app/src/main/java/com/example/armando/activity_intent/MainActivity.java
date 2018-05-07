package com.example.armando.activity_intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Iniciar();
    }

    public void Iniciar() {
    btn1 = (Button)findViewById(R.id.google);
    btn2 = (Button)findViewById(R.id.activity);
    btn1.setOnClickListener(this);
    btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.google:
                Uri uri = Uri.parse("https://www.google.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.activity:
                Intent i = new Intent(this,Activity2.class);
                startActivity(i);
        }
    }
}
