package com.example.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class choose_the_level extends AppCompatActivity {


    Button easy;
    Button medium;
    Button hard;


    public void OpenEasyActivity() {
        Intent t = new Intent(this, easy.class);
        startActivity(t);

    }

    public void OpenMediumActivity() {
        Intent t = new Intent(this, medium.class);
        startActivity(t);

    }

    public void OpenHardActivity() {
        Intent t = new Intent(this, hard.class);
        startActivity(t);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choose_the_level);

        easy = findViewById(R.id.button8);
        medium = findViewById(R.id.button9);
        hard = findViewById(R.id.button10);


        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenEasyActivity();
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenMediumActivity();
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenHardActivity();

            }
        });

    }

}