package com.example.mygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class hard extends AppCompatActivity {
    EditText e;
    Button add;
    TextView t;
    Button first;
    int counter = 0;
    int result = 0;
    int number;
    boolean error = false;
    AlertDialog.Builder alert;

    public void adduser() {
        error = false;
        int NumberOfUser = Integer.parseInt(e.getText().toString());
        number = NumberOfUser;

        if (NumberOfUser > 10 || NumberOfUser == 0) {
            e.setText(null);
            e.setHintTextColor(getResources().getColor(R.color.red));
            e.setHint(R.string.error);
            error = true;

        } else {

            result = result + NumberOfUser;
            e.setText(null);
            e.setHint(null);
        }
        if (result >= 100) {
            alerwen();
        }

    }//method to make the user add a number

    public void addcomp() {

        if (60 <= result && result <= 99) {
            if (result == 60) {
                result += 7;
                return;
            }
            if (result == 61) {
                result += 6;
                return;
            }
            if (result == 62) {
                result += 5;
                return;
            }
            if (result == 63) {
                result += 14;
                return;
            }
            if (result == 64) {
                result += 3;
                return;
            }
            if (result == 65) {
                result += 2;
                return;
            }

            if (result == 66) {
                result += 1;
                return;
            }
            if (result == 67) {
                result += 3;
                return;
            }
            if (result == 68) {
                result += 10;
                return;
            }
            if (result == 69) {
                result += 9;
                return;
            }
            if (result == 70) {
                result += 8;
                return;
            }

            if (result == 71) {
                result += 7;
                return;

            }
            if (result == 72) {
                result += 6;
                return;
            }
            if (result == 73) {
                result += 5;
                return;
            }
            if (result == 74) {
                result += 4;
                return;
            }
            if (result == 75) {
                result += 3;
                return;
            }

            if (result == 76) {
                result += 2;
                return;
            }
            if (result == 77) {
                result += 1;
                return;
            }
            if (result == 78) {
                result += 1;
                return;
            }
            if (result == 79) {
                result += 10;
                return;
            }
            if (result == 80) {
                result += 9;
                return;
            }
            if (result == 81) {
                result += 8;
                return;
            }
            if (result == 82) {
                result += 7;
                return;
            }
            if (result == 83) {
                result += 6;
                return;
            }
            if (result == 84) {
                result += 5;
                return;
            }
            if (result == 85) {
                result += 4;
                return;
            }
            if (result == 86) {
                result += 3;
                return;
            }
            if (result == 87) {
                result += 2;
                return;
            }
            if (result == 88) {
                result += 1;
                return;
            }
            if (result == 89) {
                result += 2;
                return;
            }
            if (result == 90) {
                result += 10;
            }
            if (result == 91) {
                result += 9;
            }
            if (result == 92) {
                result += 8;
            }
            if (result == 93) {
                result += 7;
            }
            if (result == 94) {
                result += 6;
            }
            if (result == 95) {
                result += 5;
            }
            if (result == 96) {
                result += 4;
            }
            if (result == 97) {
                result += 3;
            }
            if (result == 98) {
                result += 2;
            }
            if (result == 99) {
                result += 1;
            }


        } else {
            int max = 10;                         //add a random value
            int min = 1;
            int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
            result += random;
        }
        if (result == 100) {
            alerloss();
        }


    }//method to make the computer to add a number

    public void OpenHardActivity() {
        Intent t = new Intent(this, hard.class);
        startActivity(t);
        this.finish();

    }

    public void Open2playersActivity() {
        Intent t = new Intent(this, players2.class);
        startActivity(t);
        this.finish();
    }


    public void alerwen() {

        alert = new AlertDialog.Builder(hard.this);
        alert.setTitle(R.string.Congrtulationstoyou);
        alert.setMessage(R.string.congratulationsHard);
        alert.setCancelable(false);
        alert.setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Open2playersActivity();
            }
        });
        alert.setNegativeButton(R.string.Again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OpenHardActivity();
            }
        });
        alert.show();
    }

    public void alerloss() {

        alert = new AlertDialog.Builder(hard.this);
        alert.setTitle(R.string.Lost);
        alert.setMessage(R.string.lostHard);
        alert.setCancelable(false);

        alert.setNegativeButton(R.string.Again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                OpenHardActivity();
            }
        });
        alert.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.hard);


        e = findViewById(R.id.editTextNumber);

        add = findViewById(R.id.button3);
        t = findViewById(R.id.textView);
        first = findViewById(R.id.radioButton3);   //make the computer play first
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter >= 1) {
                    Toast m = Toast.makeText(getApplicationContext(), R.string.justclicked, Toast.LENGTH_LONG);
                    m.show();
                } else {
                    counter++;
                    addcomp();
                    t.setText(String.valueOf(result));
                }
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (e.getText().toString().trim().length() == 0) {
                    Toast m = Toast.makeText(getApplicationContext(), R.string.didnotputanumber, Toast.LENGTH_LONG);
                    m.show();
                } else {
                    adduser();
                    t.setText(String.valueOf(result));
                    if (error == false && result != 100) { //if the user did not put a wrong number
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {     //make the computer to add a number after 2 sec
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