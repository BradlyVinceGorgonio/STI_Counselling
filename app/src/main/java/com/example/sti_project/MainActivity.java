package com.example.sti_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText emailLgn, passLgn;
    Button loginBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailLgn = (EditText) findViewById(R.id.emailLgn);
        passLgn = (EditText) findViewById(R.id.passwordLgn);
        loginBtn = (Button) findViewById(R.id.LoginBtn);
        registerBtn = (Button) findViewById(R.id.registerHBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, registerBtn.class);
                startActivity(intent);
            }
        });
    }
}