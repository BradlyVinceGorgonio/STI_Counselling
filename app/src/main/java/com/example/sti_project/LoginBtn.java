package com.example.sti_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class LoginBtn extends AppCompatActivity
{
    Button logoutBtn;


    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_btn);

        logoutBtn = (Button) findViewById(R.id.LogoutBtn);

        logoutBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(LoginBtn.this, MainActivity.class);
                startActivity(intent);
                FirebaseAuth.getInstance().signOut();
            }
        });

    }

}