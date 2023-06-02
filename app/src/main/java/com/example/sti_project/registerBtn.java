package com.example.sti_project;

import static com.google.firebase.inappmessaging.internal.Logging.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;


import org.checkerframework.checker.nullness.qual.NonNull;

public class registerBtn extends AppCompatActivity
{
    private FirebaseAuth mAuth;
    private static final String TAG = "registerBtn";

    EditText name, email, pass, repass;
    Button registerBtn, alreadyBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_btn);
        mAuth = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.displayName);
        email = (EditText) findViewById(R.id.emailAddressReg);
        pass = (EditText) findViewById(R.id.passwordReg);
        repass = (EditText) findViewById(R.id.rePassword);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        alreadyBtn = (Button) findViewById(R.id.alreadyBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Semail = email.getText().toString();
                String Spass = pass.getText().toString();
                String Sname = name.getText().toString();
                String Srepass = repass.getText().toString();

                System.out.println(Spass + " " + Semail + " " + Srepass);
                if(Spass.equals(Srepass))
                {

                    createAccount(Semail,Spass);

                }



            }
        });

    }

    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(registerBtn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }

    private void updateUI(FirebaseUser user)
    {
        Intent intent = new Intent(registerBtn.this, LoginBtn.class);
        startActivity(intent);
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload() {
    }

}