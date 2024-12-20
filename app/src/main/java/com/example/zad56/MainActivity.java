package com.example.zad56;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity {
    private Button likebut;
    private Button delbut;
    private TextView textlike;
    private Button save;
    private Button see;
    private String last;
    private TextView text_des2;

    private int tealColor = Color.parseColor("#008080");
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likebut = findViewById(R.id.like);
        delbut = findViewById(R.id.delete);
        textlike = findViewById(R.id.num);
        save = findViewById(R.id.save);
        see = findViewById(R.id.see);
        text_des2 = findViewById(R.id.text_opis2);

        likebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                textlike.setText(count + " polubień");

            }
        });
        delbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count > 0){
                    count--;
                    textlike.setText(count + " polubień");
                }
                else{
                    textlike.setText(count + " polubień");
                }

            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email1 = ((EditText)findViewById(R.id.email)).getText().toString().trim();
                String haslo1 = ((EditText)findViewById(R.id.pass1)).getText().toString().trim();
                String haslo2 = ((EditText)findViewById(R.id.pass2)).getText().toString().trim();

                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
                    text_des2.setText("Nieprawdiłowy adres e-mail");
                }
                else if(!haslo1.equals(haslo2)){
                    text_des2.setText("Hasła się różnią");
                }
                else{
                    text_des2.setText("Zarejestrowano: " + email1);
                    last = email1;
                }
            }
        });

        findViewById(R.id.see).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                text_des2.setText(last);
            }
        });

    };
}