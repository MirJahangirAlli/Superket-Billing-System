package com.example.loginpage;

import static com.example.loginpage.R.id.forward;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton move;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        move=(ImageButton) findViewById(forward);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextPage();
            }

            private void nextPage() {
                Intent intent=new Intent(MainActivity.this, welcome.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Exit the application when the back button is pressed
        finishAffinity();
    }

}