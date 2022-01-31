package com.example.gitapi.Views.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gitapi.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity  {
    Button createaccountBtn;
    EditText username,password;
    Button Loginbtn;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        initialising firebaseauth
        firebaseAuth =FirebaseAuth.getInstance();

        createaccountBtn = findViewById(R.id.create_account_button);
        createaccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
        username=findViewById(R.id.Username);
        password=findViewById(R.id.password);
        Loginbtn=(Button)findViewById(R.id.Login_button);



        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username=username.getText().toString();
                String Password=password.getText().toString();

//
                   if (username.getText().toString().isEmpty() ) {
                    username.setError("Email is Missing");
//                        Toast.makeText(Login.this, "Email and Password not Filled", Toast.LENGTH_SHORT).show();

                    }

                  if (password.getText().toString().isEmpty()) {
                    password.setError("Password is Missing");
//                        Toast.makeText(Login.this, "Password not Filled", Toast.LENGTH_SHORT).show();

                    }


            //User Login
            // using firebaseauth instance
                else {
                   firebaseAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                       @Override
                       public void onSuccess(AuthResult authResult) {
                           startActivity(new Intent(getApplicationContext(), MainActivity.class));
                           finish();
                       }
                   }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   });

               }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

    }

}