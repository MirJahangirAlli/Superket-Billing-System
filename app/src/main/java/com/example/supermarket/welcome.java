package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class welcome extends AppCompatActivity {

    private Button register,login;
    private ImageButton backword;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        register=(Button) findViewById(R.id.signup);
        login=(Button) findViewById(R.id.login);
        backword=(ImageButton) findViewById(R.id.back);
        backword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(welcome.this,MainActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });


    }
    public void openActivity(){
        Intent intent=new Intent(this,Cashier_Login.class);
        startActivity(intent);
    }
    public void openlogin(){
        Intent intent=new Intent(this, login.class);
        startActivity(intent);

    }
    @Override
    public void onBackPressed() {
        // Launch another activity when the back button is pressed
        Intent intent = new Intent(welcome.this, MainActivity.class);
        startActivity(intent);
        finish(); // Optional: Finish the current activity if you don't want to go back to it by pressing back again
    }
}