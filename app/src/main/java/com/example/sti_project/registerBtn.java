package com.example.sti_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class registerBtn extends AppCompatActivity
{
    private FirebaseAuth mAuth;

    EditText name, email, pass, repass;
    Button registerBtn, alreadyBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_btn);


    }
}