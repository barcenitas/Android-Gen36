package com.example.dell.a17_activity;

        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btn;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Browser();
        btn2 =  findViewById(R.id.activity);
        btn2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                openAct2();
            }
        } );
    }

    public void Browser(){

        btn = findViewById(R.id.nav);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent navintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
                startActivity(navintent);

            }
        });
    }

    public void openAct2(){

        Intent next;
        next = new Intent (this, Main2Activity.class);
        startActivity(next);

    }

}
