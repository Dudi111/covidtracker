package com.example.codingeval2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String validemail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private EditText email;
    private EditText password;
    private Button mbtnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isemailvalid() && ispasswordvalid()) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    private void init(){
        email=findViewById(R.id.etemail);
        password=findViewById(R.id.etpassword);
        mbtnlogin=findViewById(R.id.btnlogin);
    }
    private boolean isemailvalid(){
        if(email.getText().toString().matches(validemail)){
           return true;
        }else {
            email.setError("Invalid email");
            return false;
        }
    }
    private boolean ispasswordvalid(){
        if(password.getText().toString().length()>=6){
            return true;
        }else {
            password.setError("password length small");
            return false;
        }
    }
}