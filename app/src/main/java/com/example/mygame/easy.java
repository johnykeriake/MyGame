package com.example.mygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class easy extends AppCompatActivity {
    EditText e;
    Button add;
    TextView t;
    int result=0;
    int number;
    Button first;
    int counter=0;
    boolean error=false;
    AlertDialog.Builder alert;
    public void adduser(){
        error=false;
        int NumberOfUser = Integer.parseInt(e.getText().toString());
        number = NumberOfUser;

        if (NumberOfUser > 10 || NumberOfUser == 0) {
            e.setText(null);
            e.setHintTextColor(getResources().getColor(R.color.red));
            e.setHint(R.string.error);
            error=true;

        } else {

            result = result + NumberOfUser;
            e.setText(null);
            e.setHint(null);
        }
        if (result >= 100) {
           alerwen();
           
        }

    }

    public void addcomp(){
        if(90<=result&&result<=99){
            if(result==90){
                result+=10;
            }
            if(result==91){
                result+=9;
            }
            if(result==92){
                result+=8;
            }
            if(result==93){
                result+=7;
            }
            if(result==94){
                result+=6;
            }
            if(result==95){
                result+=5;
            }
            if(result==96){
                result+=4;
            }
            if(result==97){
                result+=3;
            }
            if(result==98){
                result+=2;
            }
            if(result==99){
                result+=1;
            }
        }
        else{
            int max=10;
            int min=1;
            int random = (int)Math.floor(Math.random()*(max-min+1)+min);
            result+=random;
        }
        if(result==100){
            alerloss();
        }



    } //method to make the computer to add a number

    public void OpenMediumActivity(){
        Intent t=new Intent(this,medium.class);
        this.finish();
        startActivity(t);


    }
    public void OpenEasyActivity(){
        Intent t=new Intent(this,easy.class);
        startActivity(t);
        this.finish();


    }
    public void alerwen(){

        alert=new AlertDialog.Builder(easy.this);
        alert.setTitle(R.string.Congrtulationstoyou);
        alert.setMessage(R.string.CongrtulationsEasy);
        alert.setCancelable(false);
        alert.setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OpenMediumActivity();
            }
        });
        alert.setNegativeButton(R.string.Again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OpenEasyActivity();
            }
        });
        alert.show();
    }
    public void alerloss(){

        alert=new AlertDialog.Builder(easy.this);
        alert.setTitle(R.string.badLuck);
        alert.setMessage(R.string.losteasy);
        alert.setCancelable(false);

        alert.setNegativeButton(R.string.Again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OpenEasyActivity();
            }
        });
        alert.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.easy);


        e=findViewById(R.id.editTextNumber4);
        add=findViewById(R.id.button7);
        t=findViewById(R.id.textView4);
        first=findViewById(R.id.radioButton);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter>=1){
                    Toast m=Toast.makeText(getApplicationContext(),R.string.justclicked,Toast.LENGTH_LONG);
                    m.show();
                }else{
                    counter++;
                    addcomp();
                    t.setText(String.valueOf(result));
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(e.getText().toString().trim().length() == 0){
                    Toast m=Toast.makeText(getApplicationContext(),R.string.didnotputanumber,Toast.LENGTH_LONG);
                    m.show();
                }
                else {
                    adduser();
                    t.setText(String.valueOf(result));
                    if (error == false&&result!=100) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                addcomp();
                                t.setText(String.valueOf(result));
                            }
                        }, 2000);

                    }
                }
            }
        });







    }
}