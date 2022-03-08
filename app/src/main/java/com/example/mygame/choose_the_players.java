package com.example.mygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class choose_the_players extends AppCompatActivity {


    Button player1;
    Button players2;

    public void open1playerActivity() {                //method to move to 1 player activity
        Intent open = new Intent(this, choose_the_level.class);
        startActivity(open);

    }

    public void open2playersActivity() {                //method to move to 1 player activity
        Intent open = new Intent(this, com.example.mygame.players2.class);
        startActivity(open);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choose_the_players);

        player1 = findViewById(R.id.player1);
        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open1playerActivity();
            }
        });
        players2 = findViewById(R.id.players2);
        players2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                open2playersActivity();
            }
        });


    }

}