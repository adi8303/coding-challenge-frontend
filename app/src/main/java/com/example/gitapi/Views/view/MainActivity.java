package com.example.gitapi.Views.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gitapi.R;
import com.example.gitapi.Views.UserActivity;

public class MainActivity extends AppCompatActivity {

    private Button logIn;
    private EditText inputUserName;

    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logIn = (Button) findViewById(R.id.btn_login);
        inputUserName = (EditText) findViewById(R.id.input_username);


    }

    public void getUser(View view){
       if(inputUserName.getText().toString().isEmpty()){
           inputUserName.setError("Github Id Required");

       }
       else {
           i = new Intent(MainActivity.this, UserActivity.class);
           i.putExtra("STRING_I_NEED", inputUserName.getText().toString());
           startActivity(i);
       }
    }
}