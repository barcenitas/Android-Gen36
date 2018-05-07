package com.example.hector.miercoles1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btn; //creamos un bot´pon
    ImageView img;
    Bitmap bmp;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //se iniciará la aplicación
        Iniciar();
    }

    public void Iniciar(){
        btn=(Button)findViewById(R.id.btnCamara);
        btn.setOnClickListener(this);
        img=(ImageView)findViewById(R.id.imagen);
    }

    @Override

    public void onClick(View view){
        switch(view.getId())
        {
            case R.id.btnCamara:
                i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,5); //pedimos al intent que nos regrese algo al iniciarlo; ponemos numero para identificar a la intent, mientras que no sea 0
        }

    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
    super.onActivityResult(requestCode,resultCode,data);
    if((resultCode == Activity.RESULT_OK)&&requestCode==5){
        Bundle ext=data.getExtras();
        bmp=(Bitmap)ext.get("data");
    }

    }



}
