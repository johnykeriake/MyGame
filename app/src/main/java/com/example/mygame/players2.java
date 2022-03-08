package com.example.mygame;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class players2 extends AppCompatActivity {

    Button player1;
    Button player2;
    EditText ee;
    TextView tt;
    int result = 0;
    int number;


    public void add() {
        int NumberOfUser = Integer.parseInt(ee.getText().toString());
        number = NumberOfUser;
        if (result >= 100) {
            return;
        }
        if (NumberOfUser > 10 || NumberOfUser == 0) {
            ee.setText(null);
            ee.setHintTextColor(getResources().getColor(R.color.red));
            ee.setHint("error!!");
        } else {

            result = result + NumberOfUser;
            ee.setText(null);
            ee.setHint(null);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.players2);

        player1 = findViewById(R.id.button5);
        player2 = findViewById(R.id.button6);
        tt = findViewById(R.id.textView3);
        ee = findViewById(R.id.editTextNumber3);
        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ee.getText().toString().trim().length() == 0) {
                    Toast m = Toast.makeText(getApplicationContext(), "you didn't put a number!", Toast.LENGTH_LONG);
                    m.show();
                } else {
                    add();
                    tt.setText(String.valueOf(result));
                }
            }
        });
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ee.getText().toString().trim().length() == 0) {
                    Toast m = Toast.makeText(getApplicationContext(), "you didn't put a number!", Toast.LENGTH_LONG);
                    m.show();
                } else {
                    add();
                    tt.setText(String.valueOf(result));
                }
            }
        });

    }
}