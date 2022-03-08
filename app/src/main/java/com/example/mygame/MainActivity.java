package com.example.mygame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    Button start;
    AlertDialog.Builder alert;
    Button rules;


public void play(){                           //method to play a music
     music = MediaPlayer.create(MainActivity.this, R.raw.mm);
    music.start();
    music.setLooping(true);
}

    public void openActivity(){                //method to move to second activity
        Intent open =new Intent(this, choose_the_players.class);
        startActivity(open);

    }
    public void AlertOut(){

        alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Confirm Exit");
        alert.setMessage("Do you want to quit the game?");
        alert.setCancelable(false);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.show();
    }
    public void AlertAboutUs(){

        alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle(R.string.aboutus);
        alert.setMessage(R.string.aboutuswriting);
        alert.setCancelable(false);

        alert.setNegativeButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.show();
    }
    public void AlertRules(){

        alert=new AlertDialog.Builder(MainActivity.this);
        alert.setTitle(R.string.rulebutton);
        alert.setMessage(R.string.gameRules);
        alert.setCancelable(false);

        alert.setNegativeButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.show();
    }
    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        finish();
        startActivity(refresh);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    AlertOut();
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        start=findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {  //button to move to second activity
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        play();
        rules=findViewById(R.id.button4);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertRules();
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {  //option menu
    getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    if(item.getItemId()==R.id.AboutUs){
            AlertAboutUs();

    }
    if(item.getItemId()==R.id.Exit){
        AlertOut();

        }
        if(item.getItemId()==R.id.MusicOff){
            music.pause();

        }
        if(item.getItemId()==R.id.MusicOn){
            music.start();

        }
        if(item.getItemId()==R.id.English){
            music.stop();
            setLocale("en");

        }
        if(item.getItemId()==R.id.Arabic){
            music.stop();
            setLocale("ar");

        }
        return super.onOptionsItemSelected(item);
    }



}